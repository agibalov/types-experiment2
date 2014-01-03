package me.loki2302.syntax.expectations.element.statement.returnstatement;

import static org.junit.Assert.assertNull;
import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.statements.DOMReturnStatement;

public class ReturnStatementHasNoExpressionExpectation implements ReturnStatementExpectation {
    @Override
    public void check(DOMReturnStatement domReturnStatement) {
        DOMExpression domExpression = domReturnStatement.getExpression();
        assertNull(domExpression);
    }
}