package me.loki2302.syntax.expectations.element.expression.variable;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.DOMVariableReferenceExpression;

public class VariableHasSpecificNameExpectation implements VariableReferenceExpectation {
    private final String variableName;
    
    public VariableHasSpecificNameExpectation(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void check(DOMVariableReferenceExpression domVariableReferenceExpression) {
        assertEquals(variableName, domVariableReferenceExpression.getVariableName());
    }
}