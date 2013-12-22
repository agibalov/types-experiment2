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
import me.loki2302.operations.ExpressionResult;
import me.loki2302.operations.Intention;
import me.loki2302.operations.Operation;

public class App {
    public static void main(String[] args) {
        Type intType = new Type("int");
        Type doubleType = new Type("double");
        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(new CastDoubleToIntOperation(doubleType, intType));
        
        Operation castIntToDoubleOperation = new CastIntToDoubleOperation(intType, doubleType);
        operationRepository.addOperation(castIntToDoubleOperation);        
        
        DefaultImplicitCastor implicitCastor = new DefaultImplicitCastor();
        implicitCastor.allowImplicitCast(intType, doubleType, castIntToDoubleOperation);
        
        Expression expression = operationRepository.process(Intention.Add, Arrays.<Expression>asList(
                new IntConstExpression(intType), 
                new DoubleConstExpression(doubleType)), implicitCastor);
        System.out.println(expression);
    }
    
    public static interface ImplicitCastor {
        Expression wrapWithImplicitCast(Type desiredType, Expression e);
    }
    
    public static class NullImplicitCastor implements ImplicitCastor {
        @Override
        public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
            return null;
        }        
    }
    
    public static class DefaultImplicitCastor implements ImplicitCastor {
        private final List<ImplicitCast> implicitCasts = new ArrayList<ImplicitCast>();
        
        public void allowImplicitCast(Type fromType, Type toType, Operation implicitCastOperation) {
            ImplicitCast implicitCast = new ImplicitCast();
            implicitCast.fromType = fromType;
            implicitCast.toType = toType;
            implicitCast.implicitCastOperation = implicitCastOperation;
            implicitCasts.add(implicitCast);
        }
        
        @Override
        public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
            Type sourceType = e.getResultType();
            for(ImplicitCast implicitCast : implicitCasts) {
                if(!implicitCast.fromType.equals(sourceType)) {
                    continue;
                }
                
                if(!implicitCast.toType.equals(desiredType)) {
                    continue;
                }
                
                ExpressionResult expressionResult = implicitCast.implicitCastOperation.process(
                        new NullImplicitCastor(), 
                        Arrays.<Expression>asList(e));
                return expressionResult.expression;
            }
                        
            return null;
        }
        
        private static class ImplicitCast {
            public Type fromType;
            public Type toType;
            public Operation implicitCastOperation;
        }
    }
    
    public static class OperationRepository {
        private final List<Operation> operations = new ArrayList<Operation>();
        
        public void addOperation(Operation operation) {
            operations.add(operation);
        }
        
        public Expression process(Intention intention, List<Expression> arguments, ImplicitCastor implicitCastor) {
            List<ExpressionResult> expressionResults = new ArrayList<ExpressionResult>();            
            for(Operation operation : operations) {
                if(!operation.getIntention().equals(intention)) {
                    continue;
                }
                
                ExpressionResult expressionResult = operation.process(implicitCastor, arguments);
                if(!expressionResult.ok) {
                    continue;
                }               
                
                expressionResults.add(expressionResult);
            }
            
            ExpressionResult bestExpressionResult = null;
            for(ExpressionResult expressionResult : expressionResults) {
                if(bestExpressionResult == null) {
                    bestExpressionResult = expressionResult;
                    continue;
                }
                
                if(expressionResult.score >= bestExpressionResult.score) {                    
                    continue;
                }
                
                bestExpressionResult = expressionResult;
            }
            
            if(bestExpressionResult == null) {
                return null;
            }
            
            return bestExpressionResult.expression;
        }
    }
}
