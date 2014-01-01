package me.loki2302;

import static org.junit.Assert.assertEquals;
import me.loki2302.semantics.expressions.Expression;

import org.junit.Test;

public class CompilerFacadeTest {
    @Test
    public void compilerFacadeEvenWorks() {
        CompilerFacade compilerFacade = CompilerFacade.makeDefault();
        Expression expression = compilerFacade.compile(" 1 + 3.14 "); 
        assertEquals("dadd(i2d(iconst(1)),dconst(3.14))", expression.toString());
    }
}