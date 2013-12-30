package me.loki2302.operations;

import me.loki2302.Intention;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.strings.RegexStringConstraint;
import me.loki2302.strings.StringConstraint;
import me.loki2302.types.Type;

public class MakeIntConstExpressionOperation extends MakeConstExpressionOperation {
    private final Type intType;
    
    public MakeIntConstExpressionOperation(Type intType) {
        this.intType = intType;
    }
    
    @Override
    protected StringConstraint getStringConstraint() {
        return new RegexStringConstraint("^[0-9]+$");
    }

    @Override
    protected Expression processSafe(String literal) {
        return new IntConstExpression(intType, literal);
    }   
    
    @Override
    public Intention getIntention() {
        return Intention.MakeIntConst;
    }
}