package me.loki2302.semantics.operations.constraints;

public class ConstrainedArgumentResult {
    public boolean ok;
    public int score;
    public Object constrainedArgument;
    
    public static ConstrainedArgumentResult ok(int score, Object constrainedArgument) {
        ConstrainedArgumentResult constrainedArgumentResult = new ConstrainedArgumentResult();
        constrainedArgumentResult.ok = true;
        constrainedArgumentResult.score = score;
        constrainedArgumentResult.constrainedArgument = constrainedArgument;            
        return constrainedArgumentResult;
    }
    
    public static ConstrainedArgumentResult fail() {
        ConstrainedArgumentResult constrainedArgumentResult = new ConstrainedArgumentResult();
        constrainedArgumentResult.ok = false;            
        return constrainedArgumentResult;
    }
}