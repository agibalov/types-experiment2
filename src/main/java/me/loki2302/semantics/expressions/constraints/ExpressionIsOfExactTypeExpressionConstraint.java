package me.loki2302.semantics.expressions.constraints;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.types.Type;

public class ExpressionIsOfExactTypeExpressionConstraint implements ExpressionConstraint {
    private final Type requiredType;
    
    public ExpressionIsOfExactTypeExpressionConstraint(Type requiredType) {
        this.requiredType = requiredType;
    }
    
    @Override
    public ConstrainedExpressionResult test(Compiler compiler, Expression expression) {
        Type expressionType = expression.getType();
        if(expressionType.equals(requiredType)) {
            return ConstrainedExpressionResult.ok(0, expression);
        }
        
        return ConstrainedExpressionResult.fail();
    }
}