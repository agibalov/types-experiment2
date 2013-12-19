package me.loki2302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
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
        
        ImplicitCastor implicitCastor = new DefaultImplicitCastor(operationRepository);
        OperationMatch operationMatch = operationRepository.findOperation(implicitCastor, Intention.Add, Arrays.<Expression>asList(
                new IntConstExpression(intType), 
                new DoubleConstExpression(doubleType)));
        
        System.out.println(operationMatch);
    }
    
    public static interface ImplicitCastor {
        Expression wrapWithImplicitCast(Type desiredType, Expression e);
    }
    
    public static class DefaultImplicitCastor implements ImplicitCastor {
        private final static NoImplicitCastImplicitCastor noImplicitCastImplicitCastor = new NoImplicitCastImplicitCastor();
        private final OperationRepository operationRepository;
        
        public DefaultImplicitCastor(OperationRepository operationRepository) {
            this.operationRepository = operationRepository;
        }
        
        public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
            // TODO: I also need to somehow tell it the resultType I want - desiredType in this case
            OperationMatch implicitCastMatch = operationRepository.findOperation(
                    noImplicitCastImplicitCastor, 
                    Intention.ImplicitCast, 
                    Arrays.asList(e));
            
            if(implicitCastMatch == null) {
                return null;
            }
            
            List<ParameterMatch> parameterMatches = implicitCastMatch.parameterMatches;
            List<Expression> arguments = new ArrayList<Expression>();
            for(ParameterMatch parameterMatch : parameterMatches) {
                arguments.add(parameterMatch.acceptableArgument);
            }            
            
            Operation implicitCastOperation = implicitCastMatch.operation;            
            return implicitCastOperation.process(arguments);
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
                List<Intention> intentions = operation.getIntentions();
                if(!intentions.contains(intention)) {
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
    
    public static interface ExpressionConstraint {
        ConstraintMatch match(Expression expression, ImplicitCastor implicitCastor);
    }
    
    public static class ExpressionHasResultTypeExpressionConstraint implements ExpressionConstraint {
        private final Type requiredType;
        
        public ExpressionHasResultTypeExpressionConstraint(Type requiredType) {
            this.requiredType = requiredType;
        }
        
        public ConstraintMatch match(Expression expression, ImplicitCastor implicitCastor) {
            Type expressionType = expression.getResultType();
            if(expressionType.equals(requiredType)) {
                return ConstraintMatch.match(0, expression);
            }
            
            Expression acceptableExpression = implicitCastor.wrapWithImplicitCast(requiredType, expression);
            if(acceptableExpression == null) {
                return ConstraintMatch.noMatch();
            }
            
            return ConstraintMatch.match(1, acceptableExpression);
        }
    }    
    
    public static class ConstraintMatch {
        public boolean ok;
        public int score;
        public Expression expression;
        
        public static ConstraintMatch match(int score, Expression expression) {
            ConstraintMatch match = new ConstraintMatch();
            match.ok = true;
            match.score = score;
            match.expression = expression;
            return match;
        }
        
        public static ConstraintMatch noMatch() {
            ConstraintMatch match = new ConstraintMatch();
            match.ok = false;            
            return match;
        }
    }
    
    public static ExpressionConstraint isOfType(Type type) {
        return new ExpressionHasResultTypeExpressionConstraint(type);
    }
}
