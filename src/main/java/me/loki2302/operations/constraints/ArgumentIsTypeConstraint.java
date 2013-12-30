package me.loki2302.operations.constraints;

import me.loki2302.Compiler;
import me.loki2302.types.Type;
import me.loki2302.types.constraints.ConstrainedTypeResult;
import me.loki2302.types.constraints.TypeConstraint;

public class ArgumentIsTypeConstraint implements ArgumentConstraint {
    private final TypeConstraint typeConstraint;
    
    public ArgumentIsTypeConstraint(TypeConstraint typeConstraint) {
        this.typeConstraint = typeConstraint;
    }

    @Override
    public ConstrainedArgumentResult test(Compiler compiler, Object argument) {
        if(!(argument instanceof Type)) {
            return ConstrainedArgumentResult.fail();
        }
        
        Type typeArgument = (Type)argument;
        ConstrainedTypeResult constrainedTypeResult = typeConstraint.test(typeArgument);
        if(!constrainedTypeResult.ok) {
            return ConstrainedArgumentResult.fail();
        }
        
        return ConstrainedArgumentResult.ok(constrainedTypeResult.score, constrainedTypeResult.constrainedType);
    }
}