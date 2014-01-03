package me.loki2302.semantics.operations;

import java.util.List;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.constraints.AnyExpressionConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentIsExpressionConstraint;
import me.loki2302.semantics.statements.ExpressionStatement;

public class MakeExpressionStatementOperation extends AbstractOperation {
    @Override
    public Intention getIntention() {
        return Intention.MakeExpressionStatement;
    }

    @Override
    protected int getArgumentCount() {
        return 1;
    }

    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        if(index == 0) {
            return new ArgumentIsExpressionConstraint(new AnyExpressionConstraint());
        }
        
        return null;
    }

    @Override
    protected Object processSafe(List<Object> safeArguments) {
        Expression expression = (Expression)safeArguments.get(0);
        return new ExpressionStatement(expression);
    }        
}