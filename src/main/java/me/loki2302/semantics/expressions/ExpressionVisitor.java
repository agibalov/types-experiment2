package me.loki2302.semantics.expressions;

public interface ExpressionVisitor<TResult> {
    TResult visit(AddDoublesExpression e);
    TResult visit(AddIntsExpression e);
    TResult visit(CastDoubleToIntExpression e);
    TResult visit(CastIntToDoubleExpression e);
    TResult visit(IntConstExpression e);
    TResult visit(DoubleConstExpression e);
}