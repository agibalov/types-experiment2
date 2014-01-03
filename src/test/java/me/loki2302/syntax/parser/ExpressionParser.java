package me.loki2302.syntax.parser;

import me.loki2302.syntax.ParseResult;

public interface ExpressionParser {
	ParseResult parse(String expression);
}