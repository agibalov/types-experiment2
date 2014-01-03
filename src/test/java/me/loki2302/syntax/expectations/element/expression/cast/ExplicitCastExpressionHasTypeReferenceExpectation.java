package me.loki2302.syntax.expectations.element.expression.cast;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.expressions.DOMExplicitCastExpression;
import me.loki2302.syntax.dom.types.DOMTypeReference;
import me.loki2302.syntax.expectations.element.typereference.TypeReferenceExpectation;

public class ExplicitCastExpressionHasTypeReferenceExpectation implements ExplicitCastExpressionExpectation {
    private final TypeReferenceExpectation[] expectations;
    
    public ExplicitCastExpressionHasTypeReferenceExpectation(TypeReferenceExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMExplicitCastExpression domExplicitCastExpression) {
        DOMTypeReference domTypeReference = domExplicitCastExpression.getTypeReference();
        assertNotNull(domTypeReference);
        for(TypeReferenceExpectation expectation : expectations) {
            expectation.check(domTypeReference);
        }
    }	    
}