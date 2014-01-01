package me.loki2302.semantics.expressions.constraints;

import me.loki2302.semantics.expressions.Expression;

public class ConstrainedExpressionResult {
    public boolean ok;
    public int score;
    public Expression constrainedExpression;
    
    public static ConstrainedExpressionResult ok(int score, Expression constrainedExpression) {
        ConstrainedExpressionResult constrainedExpressionResult = new ConstrainedExpressionResult();
        constrainedExpressionResult.ok = true;
        constrainedExpressionResult.score = score;
        constrainedExpressionResult.constrainedExpression = constrainedExpression;
        return constrainedExpressionResult;
    }
    
    public static ConstrainedExpressionResult fail() {
        ConstrainedExpressionResult constrainedExpressionResult = new ConstrainedExpressionResult();
        constrainedExpressionResult.ok = false;
        return constrainedExpressionResult;
    }
}