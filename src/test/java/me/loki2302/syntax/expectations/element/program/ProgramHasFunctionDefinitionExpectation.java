package me.loki2302.syntax.expectations.element.program;

import static org.junit.Assert.assertTrue;

import java.util.List;

import me.loki2302.syntax.dom.functions.DOMFunctionDefinition;
import me.loki2302.syntax.dom.programs.DOMProgram;
import me.loki2302.syntax.expectations.element.function.FunctionDefinitionExpectation;

public class ProgramHasFunctionDefinitionExpectation implements ProgramExpectation {
    private final int functionDefinitionIndex;
    private final FunctionDefinitionExpectation[] expectations;
    
    public ProgramHasFunctionDefinitionExpectation(
            int functionDefinitionIndex,
            FunctionDefinitionExpectation[] expectations) {
        this.functionDefinitionIndex = functionDefinitionIndex;
        this.expectations = expectations;
    }

    @Override
    public void check(DOMProgram domProgram) {
        List<DOMFunctionDefinition> functionDefinitions = domProgram.getFunctionDefinitions();
        assertTrue(functionDefinitions.size() > functionDefinitionIndex);
        DOMFunctionDefinition domFunctionDefinition = functionDefinitions.get(functionDefinitionIndex);                    
        for(FunctionDefinitionExpectation expectation : expectations) {
            expectation.check(domFunctionDefinition);
        }            
    }	    
}