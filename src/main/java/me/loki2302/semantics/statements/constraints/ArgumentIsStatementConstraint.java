package me.loki2302.semantics.statements.constraints;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ConstrainedArgumentResult;
import me.loki2302.semantics.statements.Statement;

public class ArgumentIsStatementConstraint implements ArgumentConstraint {
    @Override
    public ConstrainedArgumentResult test(Compiler compiler, Object argument) {
        if(!(argument instanceof Statement)) {
            return ConstrainedArgumentResult.fail();
        }
        
        return ConstrainedArgumentResult.ok(0, argument);
    }        
}