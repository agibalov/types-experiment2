package me.loki2302.syntax.expectations.parser;

import me.loki2302.syntax.ParseResult;


public interface ParseResultExpectation {
	void check(ParseResult parseResult);
}