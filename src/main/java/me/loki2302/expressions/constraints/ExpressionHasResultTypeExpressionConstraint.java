package me.loki2302.expressions.constraints;

import me.loki2302.App;
import me.loki2302.Type;
import me.loki2302.App.ImplicitCastor;
import me.loki2302.expressions.Expression;

public class ExpressionHasResultTypeExpressionConstraint implements ExpressionConstraint {
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