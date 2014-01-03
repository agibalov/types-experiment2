package me.loki2302.syntax.expectations.parser;

import static org.junit.Assert.assertFalse;
import me.loki2302.syntax.ParseResult;


public class ParseResultIsBadExpectation implements ParseResultExpectation {
	@Override
	public void check(ParseResult parseResult) {
		assertFalse(parseResult.isOk());
	}		
}