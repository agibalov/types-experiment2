package me.loki2302.syntax.expectations.element.expression.unary;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.expressions.DOMUnaryExpression;
import me.loki2302.syntax.dom.expressions.DOMUnaryExpressionType;

public class UnaryExpressionHasSpecificTypeExpectation implements UnaryExpressionExpectation {
    private final DOMUnaryExpressionType expressionType;
    
    public UnaryExpressionHasSpecificTypeExpectation(DOMUnaryExpressionType expressionType) {
        this.expressionType = expressionType;
    }

    @Override
    public void check(DOMUnaryExpression domUnaryExpression) {
        assertEquals(expressionType, domUnaryExpression.getExpressionType());             
    }	    
}