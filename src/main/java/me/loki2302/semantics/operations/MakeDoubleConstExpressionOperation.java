package me.loki2302.semantics.operations;

import me.loki2302.semantics.Intention;
import me.loki2302.semantics.expressions.DoubleConstExpression;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.strings.RegexStringConstraint;
import me.loki2302.semantics.strings.StringConstraint;
import me.loki2302.semantics.types.Type;

public class MakeDoubleConstExpressionOperation extends MakeConstExpressionOperation {
    private final Type doubleType;
    
    public MakeDoubleConstExpressionOperation(Type doubleType) {
        this.doubleType = doubleType;
    }
    
    @Override
    protected StringConstraint getStringConstraint() {
        return new RegexStringConstraint("^[0-9]+\\.[0-9]+$");
    }

    @Override
    protected Expression processSafe(String literal) {
        return new DoubleConstExpression(doubleType, literal);
    }

    @Override
    public Intention getIntention() {
        return Intention.MakeDoubleConst;
    }
}