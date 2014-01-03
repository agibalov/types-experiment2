package me.loki2302.syntax.expectations.element.parameter;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.functions.DOMParameterDefinition;

public class ParameterDefinitionHasNameExpectation implements ParameterDefinitionExpectation {
    private final String parameterName;
    
    public ParameterDefinitionHasNameExpectation(String parameterName) {
        this.parameterName = parameterName;
    }
    
    @Override
    public void check(DOMParameterDefinition domFunctionDefinition) {
        assertEquals(parameterName, domFunctionDefinition.getName());
    }
}