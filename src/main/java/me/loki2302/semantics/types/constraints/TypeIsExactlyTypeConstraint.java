package me.loki2302.semantics.types.constraints;

import me.loki2302.semantics.types.Type;

public class TypeIsExactlyTypeConstraint implements TypeConstraint {
    private final Type requiredType;
    
    public TypeIsExactlyTypeConstraint(Type requiredType) {
        this.requiredType = requiredType;
    }
    
    @Override
    public ConstrainedTypeResult test(Type type) {
        if(type.equals(requiredType)) {
            return ConstrainedTypeResult.ok(0, requiredType);
        }
        
        return ConstrainedTypeResult.fail();
    }        
}