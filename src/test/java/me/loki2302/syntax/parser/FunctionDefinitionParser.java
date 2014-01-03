package me.loki2302.syntax.parser;

import me.loki2302.syntax.ParseResult;
import me.loki2302.syntax.Parser;

public class FunctionDefinitionParser implements ExpressionParser {
    @Override
    public ParseResult parse(String expression) {
        Parser parser = new Parser();
        return parser.parseFunction(expression);
    }
}