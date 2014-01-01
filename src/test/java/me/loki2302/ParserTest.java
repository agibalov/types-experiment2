package me.loki2302;

import static org.junit.Assert.*;
import me.loki2302.dom.Parser;

import org.junit.Test;

public class ParserTest {
    private final static Parser parser = new Parser();    
    
    @Test
    public void canParseIntLiteral() {
        assertEquals("i[123]", parse(" 123 "));
    }
    
    @Test
    public void canParseDoubleLiteral() {
        assertEquals("d[3.14]", parse(" 3.14 "));
    }
    
    @Test
    public void canParseOperatorAdd() {
        assertEquals("add(i[123],d[3.14])", parse(" 123 + 3.14 "));
    }
    
    private static String parse(String expressionString) {
        return parser.parse(expressionString).toString();
    }
}