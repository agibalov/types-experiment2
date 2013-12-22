package me.loki2302.operations;

import me.loki2302.expressions.Expression;

public class ExpressionResult {
    public boolean ok;
    public int score;
    public Expression expression;
    
    public static ExpressionResult ok(int score, Expression expression) {
        ExpressionResult expressionResult = new ExpressionResult();
        expressionResult.ok = true;
        expressionResult.score = score;
        expressionResult.expression = expression;
        return expressionResult;
    }
    
    public static ExpressionResult error() {
        ExpressionResult expressionResult = new ExpressionResult();
        expressionResult.ok = false;
        return expressionResult;
    }
}