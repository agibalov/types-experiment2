package me.loki2302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.expressions.constraints.ConstraintMatch;
import me.loki2302.expressions.constraints.ExpressionConstraint;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.operations.Intention;
import me.loki2302.operations.Operation;

public class App {
    public static void main(String[] args) {
        Type intType = new Type("int");
        Type doubleType = new Type("double");
        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(new CastIntToDoubleOperation(intType, doubleType));
        operationRepository.addOperation(new CastDoubleToIntOperation(doubleType, intType));
        
        OperationInvoker operationInvoker = new OperationInvoker();        
        
        DefaultImplicitCastor implicitCastor = new DefaultImplicitCastor(operationRepository, operationInvoker);
        implicitCastor.allowImplicitCast(intType, doubleType);
        
        OperationMatch operationMatch = operationRepository.findOperation(implicitCastor, Intention.Add, Arrays.<Expression>asList(
                new IntConstExpression(intType), 
                new DoubleConstExpression(doubleType)));
        
        Expression expression = operationInvoker.invoke(
                operationMatch.operation, 
                operationMatch.parameterMatches);
        
        System.out.println(expression);
    }
    
    public static interface ImplicitCastor {
        Expression wrapWithImplicitCast(Type desiredType, Expression e);
    }
    
    public static class DefaultImplicitCastor implements ImplicitCastor {
        private final static NoImplicitCastImplicitCastor noImplicitCastImplicitCastor = new NoImplicitCastImplicitCastor();
        private final List<ImplicitCast> implicitCasts = new ArrayList<ImplicitCast>();
        private final OperationRepository operationRepository;
        private final OperationInvoker operationInvoker;
        
        public DefaultImplicitCastor(OperationRepository operationRepository, OperationInvoker operationInvoker) {
            this.operationRepository = operationRepository;
            this.operationInvoker = operationInvoker;
        }
        
        public void allowImplicitCast(Type fromType, Type toType) {
            ImplicitCast implicitCast = new ImplicitCast(fromType, toType);
            implicitCasts.add(implicitCast);
        }
        
        public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
            boolean allowImplicitCast = false;
            Type fromType = e.getResultType();            
            for(ImplicitCast implicitCast : implicitCasts) {
                if(!implicitCast.fromType.equals(fromType)) {
                    continue;
                }
                
                if(!implicitCast.toType.equals(desiredType)) {
                    continue;
                }
                
                allowImplicitCast = true;
                break;
            }
            
            if(!allowImplicitCast) {
                return null;
            }
            
            // TODO: I also need to somehow tell it the resultType I want - desiredType in this case
            OperationMatch implicitCastMatch = operationRepository.findOperation(
                    noImplicitCastImplicitCastor, 
                    Intention.Cast, 
                    Arrays.asList(e));
            
            if(implicitCastMatch == null) {
                return null;
            }
            
            Operation implicitCastOperation = implicitCastMatch.operation;
            List<ParameterMatch> parameterMatches = implicitCastMatch.parameterMatches;
            return operationInvoker.invoke(implicitCastOperation, parameterMatches);
        }
        
        private static class ImplicitCast {
            public Type fromType;
            public Type toType;
            
            public ImplicitCast(Type fromType, Type toType) {
                this.fromType = fromType;
                this.toType = toType;
            }
        }
    }
    
    public static class OperationInvoker {
        public Expression invoke(Operation operation, List<ParameterMatch> parameterMatches) {
            List<Expression> arguments = new ArrayList<Expression>();
            for(ParameterMatch parameterMatch : parameterMatches) {
                arguments.add(parameterMatch.acceptableArgument);
            }
                        
            return operation.process(arguments);
        }
    }
    
    public static class NoImplicitCastImplicitCastor implements ImplicitCastor {
        public Expression wrapWithImplicitCast(Type desiredType, Expression e) {            
            return null;
        }        
    }
        
    public static class OperationMatch {
        public Operation operation;
        public List<ParameterMatch> parameterMatches;
        
        public int getScore() {
            int score = 0;
            for(ParameterMatch parameterMatch : parameterMatches) {
                score += parameterMatch.score;
            }
            
            return score;
        }
        
        public static OperationMatch match(Operation operation, List<ParameterMatch> parameterMatches) {
            OperationMatch match = new OperationMatch();
            match.operation = operation;
            match.parameterMatches = parameterMatches;
            return match;
        }
        
        @Override
        public String toString() {
            return String.format("OperationMatch{op=%s,p=%s}", operation, parameterMatches);
        }
    }
    
    public static class ParameterMatch {
        public int score;
        public Expression acceptableArgument;
        
        public static ParameterMatch match(int score, Expression acceptableArgument) {
            ParameterMatch match = new ParameterMatch();
            match.score = score;
            match.acceptableArgument = acceptableArgument;
            return match;
        }
        
        @Override
        public String toString() {
            return String.format("P{%d,%s}", score, acceptableArgument);
        }
    }
    
    public static class OperationRepository {
        private final List<Operation> operations = new ArrayList<Operation>();
        
        public void addOperation(Operation operation) {
            operations.add(operation);
        }
        
        public OperationMatch findOperation(ImplicitCastor implicitCastor, Intention intention, List<Expression> arguments) {            
            List<OperationMatch> operationMatches = new ArrayList<OperationMatch>();            
            for(Operation operation : operations) {
                if(!operation.getIntention().equals(intention)) {
                    continue;
                }
                
                List<Parameter> parameters = operation.getParameters();
                if(parameters.size() != arguments.size()) {
                    continue;
                }
                
                boolean argumentsWereOk = true;
                List<ParameterMatch> parameterMatches = new ArrayList<ParameterMatch>();
                for(int i = 0; i < parameters.size(); ++i) {                    
                    Parameter parameter = parameters.get(i);
                    ExpressionConstraint expressionConstraint = parameter.getExpressionConstraint();
                    Expression argument = arguments.get(i);
                    
                    ConstraintMatch constraintMatch = expressionConstraint.match(argument, implicitCastor);
                    if(!constraintMatch.ok) {
                        argumentsWereOk = false;
                        break;
                    }
                    
                    ParameterMatch parameterMatch = ParameterMatch.match(constraintMatch.score, constraintMatch.expression);
                    parameterMatches.add(parameterMatch);
                }
                
                if(!argumentsWereOk) {
                    continue;
                }
                
                OperationMatch operationMatch = OperationMatch.match(operation, parameterMatches);
                operationMatches.add(operationMatch);
            }
            
            OperationMatch bestOperationMatch = null;
            for(OperationMatch operationMatch : operationMatches) {
                if(bestOperationMatch == null) {
                    bestOperationMatch = operationMatch;
                    continue;
                }
                
                if(bestOperationMatch.getScore() > operationMatch.getScore()) {
                    bestOperationMatch = operationMatch;
                }
            }
            
            return bestOperationMatch;
        }
    }
    
    public static class Parameter {
        private final String name;
        private final ExpressionConstraint expressionConstraint;
        
        public Parameter(String name, ExpressionConstraint expressionConstraint) {
            this.name = name;
            this.expressionConstraint = expressionConstraint;
        }
        
        public String getName() {
            return name;
        }
        
        public ExpressionConstraint getExpressionConstraint() {
            return expressionConstraint;
        }
    }
}
