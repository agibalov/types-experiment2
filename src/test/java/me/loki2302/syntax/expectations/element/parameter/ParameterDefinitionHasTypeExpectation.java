package me.loki2302.syntax.expectations.element.parameter;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.functions.DOMParameterDefinition;
import me.loki2302.syntax.dom.types.DOMTypeReference;
import me.loki2302.syntax.expectations.element.typereference.TypeReferenceExpectation;

public class ParameterDefinitionHasTypeExpectation implements ParameterDefinitionExpectation {
    private final TypeReferenceExpectation[] expectations;
    
    public ParameterDefinitionHasTypeExpectation(TypeReferenceExpectation[] expectations) {
        this.expectations = expectations;
    }

    @Override
    public void check(DOMParameterDefinition domParameterDefinition) {
        DOMTypeReference domTypeReference = domParameterDefinition.getType();
        assertNotNull(domTypeReference);
        for(TypeReferenceExpectation expectation : expectations) {
            expectation.check(domTypeReference);
        }
    }
}