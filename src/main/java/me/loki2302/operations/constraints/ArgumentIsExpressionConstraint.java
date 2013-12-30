package me.loki2302.operations.constraints;

import me.loki2302.Compiler;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.constraints.ConstrainedExpressionResult;
import me.loki2302.expressions.constraints.ExpressionConstraint;

public class ArgumentIsExpressionConstraint implements ArgumentConstraint {
    private final ExpressionConstraint expressionConstraint;
    
    public ArgumentIsExpressionConstraint(ExpressionConstraint expressionConstraint) {
        this.expressionConstraint = expressionConstraint;
    }
    
    @Override
    public ConstrainedArgumentResult test(Compiler compiler, Object argument) {
        if(!(argument instanceof Expression)) {
            return ConstrainedArgumentResult.fail();
        }
        
        Expression expressionArgument = (Expression)argument;
        ConstrainedExpressionResult constrainedExpressionResult = expressionConstraint.test(compiler, expressionArgument);
        if(!constrainedExpressionResult.ok) {
            return ConstrainedArgumentResult.fail();
        }
        
        return ConstrainedArgumentResult.ok(constrainedExpressionResult.score, constrainedExpressionResult.constrainedExpression);
    }        
}