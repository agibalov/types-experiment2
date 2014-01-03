package me.loki2302.syntax.expectations.element.expression.unary;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.DOMUnaryExpression;
import me.loki2302.syntax.dom.DOMUnaryExpressionType;

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