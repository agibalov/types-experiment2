package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.Expression;

public class MakeOperatorAddExpressionRequest extends EEERequest {
    private final Expression left;
    private final Expression right;
    
    public MakeOperatorAddExpressionRequest(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public Intention getIntention() {
        return Intention.OperatorAdd;
    }

    @Override
    protected Expression getLeft() {
        return left;
    }

    @Override
    protected Expression getRight() {
        return right;
    }        
}