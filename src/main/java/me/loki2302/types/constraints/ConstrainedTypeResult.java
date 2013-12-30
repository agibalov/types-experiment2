package me.loki2302.types.constraints;

import me.loki2302.types.Type;

public class ConstrainedTypeResult {
    public boolean ok;
    public int score;
    public Type constrainedType;
    
    public static ConstrainedTypeResult ok(int score, Type constrainedType) {
        ConstrainedTypeResult constrainedTypeResult = new ConstrainedTypeResult();
        constrainedTypeResult.ok = true;
        constrainedTypeResult.score = score;
        constrainedTypeResult.constrainedType = constrainedType;
        return constrainedTypeResult;
    }
    
    public static ConstrainedTypeResult fail() {
        ConstrainedTypeResult constrainedTypeResult = new ConstrainedTypeResult();
        constrainedTypeResult.ok = false;
        return constrainedTypeResult;
    }
}