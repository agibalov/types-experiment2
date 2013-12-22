package me.loki2302.operations;

import java.util.ArrayList;
import java.util.List;

import me.loki2302.App.ImplicitCastor;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ConstraintMatch;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public abstract class AbstractOperation implements Operation {
    @Override
    public ExpressionResult process(ImplicitCastor implicitCastor, List<Expression> arguments) {
        if(arguments.size() != getParameterCount()) {
            return ExpressionResult.error();
        }
        
        int score = 0;            
        List<Expression> adaptedArguments = new ArrayList<Expression>();
        for(int parameterIndex = 0; parameterIndex < getParameterCount(); ++parameterIndex) {
            ExpressionConstraint expressionConstraint = getExpressionConstraint(parameterIndex);
            Expression argument = arguments.get(parameterIndex);
            ConstraintMatch constraintMatch = expressionConstraint.match(argument, implicitCastor);
            if(!constraintMatch.ok) {
                return ExpressionResult.error();
            }                
            
            score += constraintMatch.score;
            adaptedArguments.add(constraintMatch.expression);
        }
                    
        return ExpressionResult.ok(score, processSafe(adaptedArguments));
    }
    
    protected abstract int getParameterCount();
    protected abstract ExpressionConstraint getExpressionConstraint(int parameterIndex);
    protected abstract Expression processSafe(List<Expression> arguments);
}