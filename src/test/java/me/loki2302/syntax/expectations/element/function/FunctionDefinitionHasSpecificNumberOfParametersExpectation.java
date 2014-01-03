package me.loki2302.syntax.expectations.element.function;

import static org.junit.Assert.assertEquals;
import me.loki2302.syntax.dom.functions.DOMFunctionDefinition;

public class FunctionDefinitionHasSpecificNumberOfParametersExpectation implements FunctionDefinitionExpectation {
    private final int parameterCount;
    
    public FunctionDefinitionHasSpecificNumberOfParametersExpectation(int parameterCount) {
        this.parameterCount = parameterCount;
    }
    
    @Override
    public void check(DOMFunctionDefinition domFunctionDefinition) {
        assertEquals(parameterCount, domFunctionDefinition.getParameterDefinitions().size());
    }
}