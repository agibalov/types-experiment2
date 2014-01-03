package me.loki2302.syntax.expectations.element.statement.whilestatement;

import static org.junit.Assert.assertNotNull;
import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.statements.DOMWhileStatement;
import me.loki2302.syntax.expectations.element.expression.ExpressionExpectation;

public class WhileStatementHasConditionExpressionExpectation implements WhileStatementExpectation {
    private final ExpressionExpectation[] expectations;
    
    public WhileStatementHasConditionExpressionExpectation(ExpressionExpectation[] expectations) {
        this.expectations = expectations;
    }
    
    @Override
    public void check(DOMWhileStatement domWhileStatement) {
        DOMExpression conditionExpression = domWhileStatement.getConditionExpression();
        assertNotNull(conditionExpression);
        for(ExpressionExpectation expectation : expectations) {
            expectation.check(conditionExpression);
        }
    }        
}