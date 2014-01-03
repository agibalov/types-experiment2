package me.loki2302.semantics.operations;

import java.util.List;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ArgumentIsListOfStatementsArgumentConstraint;
import me.loki2302.semantics.statements.CompositeStatement;
import me.loki2302.semantics.statements.Statement;

public class MakeCompositeStatementOperation extends AbstractOperation {
    @Override
    public Intention getIntention() {
        return Intention.MakeCompositeStatement;
    }

    @Override
    protected int getArgumentCount() {
        return 1;
    }

    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        return new ArgumentIsListOfStatementsArgumentConstraint();
    }

    @Override
    protected Object processSafe(List<Object> safeArguments) {
        List<Statement> statements = (List<Statement>)safeArguments.get(0);
        return new CompositeStatement(statements);
    }
}