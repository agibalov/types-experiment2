package me.loki2302.semantics.strings;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ConstrainedArgumentResult;

public class ArgumentIsStringConstraint implements ArgumentConstraint {
    private final StringConstraint stringConstraint;
    
    public ArgumentIsStringConstraint(StringConstraint stringConstraint) {
        this.stringConstraint = stringConstraint;
    }
    
    @Override
    public ConstrainedArgumentResult test(Compiler compiler, Object argument) {
        if(!(argument instanceof String)) {
            return ConstrainedArgumentResult.fail();
        }
        
        String stringArgument = (String)argument;
        ConstrainedStringResult constrainedStringResult = stringConstraint.test(stringArgument);
        if(!constrainedStringResult.ok) {
            return ConstrainedArgumentResult.fail();
        }
        
        return ConstrainedArgumentResult.ok(constrainedStringResult.score, constrainedStringResult.constrainedString);
    }        
}