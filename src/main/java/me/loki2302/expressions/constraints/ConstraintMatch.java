package me.loki2302.expressions.constraints;

import me.loki2302.expressions.Expression;

public class ConstraintMatch {
    public boolean ok;
    public int score;
    public Expression expression;
    
    public static ConstraintMatch match(int score, Expression expression) {
        ConstraintMatch match = new ConstraintMatch();
        match.ok = true;
        match.score = score;
        match.expression = expression;
        return match;
    }
    
    public static ConstraintMatch noMatch() {
        ConstraintMatch match = new ConstraintMatch();
        match.ok = false;            
        return match;
    }
}