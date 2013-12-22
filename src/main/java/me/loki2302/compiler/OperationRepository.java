package me.loki2302.compiler;

import java.util.ArrayList;
import java.util.List;

import me.loki2302.expressions.Expression;
import me.loki2302.operations.ExpressionResult;
import me.loki2302.operations.Intention;
import me.loki2302.operations.Operation;

public class OperationRepository {
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