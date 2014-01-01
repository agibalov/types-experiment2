package me.loki2302.semantics.operations;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.expressions.IntConstExpression;
import me.loki2302.semantics.strings.RegexStringConstraint;
import me.loki2302.semantics.strings.StringConstraint;
import me.loki2302.semantics.types.Type;

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