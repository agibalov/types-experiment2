package me.loki2302.expressions.constraints;

import me.loki2302.Compiler;
import me.loki2302.expressions.Expression;
import me.loki2302.types.Type;

public class ExpressionIsOfCompatibleTypeExpressionConstraint implements ExpressionConstraint {
    private final Type requiredType;
    
    public ExpressionIsOfCompatibleTypeExpressionConstraint(Type requiredType) {
        this.requiredType = requiredType;
    }
    
    @Override
    public ConstrainedExpressionResult test(Compiler compiler, Expression expression) {
        Type expressionType = expression.getType();
        if(expressionType.equals(requiredType)) {
            return ConstrainedExpressionResult.ok(0, expression);
        }
        
        Expression castExpression = compiler.castImplicitly(requiredType, expression);
        if(castExpression != null) {
            return ConstrainedExpressionResult.ok(1, castExpression);
        }
        
        return ConstrainedExpressionResult.fail();
    }        
}