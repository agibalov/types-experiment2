package me.loki2302.syntax.expectations.element.statement.forstatement;

import static org.junit.Assert.assertNull;
import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.statements.DOMForStatement;

public class ForStatementHasNoConditionExpressionExpectation implements ForStatementExpectation {
    @Override
    public void check(DOMForStatement domForStatement) {
        DOMExpression conditionExpression = domForStatement.getConditionExpression();
        assertNull(conditionExpression);
    }        
}