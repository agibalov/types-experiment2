package me.loki2302.semantics.operations;

import java.util.List;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.statements.Function;
import me.loki2302.semantics.statements.Statement;
import me.loki2302.semantics.statements.constraints.ArgumentIsStatementConstraint;
import me.loki2302.semantics.strings.ArgumentIsStringConstraint;
import me.loki2302.semantics.strings.RegexStringConstraint;

public class MakeFunctionOperation extends AbstractOperation {
    @Override
    public Intention getIntention() {
        return Intention.MakeFunction;
    }

    @Override
    protected int getArgumentCount() {
        return 2;
    }

    @Override
    protected ArgumentConstraint getArgumentConstraint(int index) {
        if(index == 0) {
            return new ArgumentIsStringConstraint(new RegexStringConstraint("^[a-z]+$")); 
        }
        
        if(index == 1) {
            return new ArgumentIsStatementConstraint();
        }
        
        throw new RuntimeException();
    }

    @Override
    protected Object processSafe(List<Object> safeArguments) {
        String name = (String)safeArguments.get(0);
        Statement body = (Statement)safeArguments.get(1);
        return new Function(name, body);
    }
}