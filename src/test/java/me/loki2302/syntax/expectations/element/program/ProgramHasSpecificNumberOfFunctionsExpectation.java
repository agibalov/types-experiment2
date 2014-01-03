package me.loki2302.syntax.expectations.element.program;

import static org.junit.Assert.assertEquals;

import java.util.List;

import me.loki2302.syntax.dom.DOMFunctionDefinition;
import me.loki2302.syntax.dom.DOMProgram;

public class ProgramHasSpecificNumberOfFunctionsExpectation implements ProgramExpectation {
    private final int functionCount;
    
    public ProgramHasSpecificNumberOfFunctionsExpectation(int functionCount) {
        this.functionCount = functionCount;
    }

    @Override
    public void check(DOMProgram domProgram) {
        List<DOMFunctionDefinition> functionDefinitions = domProgram.getFunctionDefinitions();
        assertEquals(functionCount, functionDefinitions.size());
    }	    
}