package me.loki2302.semantics.statements;

public interface StatementVisitor<TResult> {
    TResult visit(CompositeStatement s);
    TResult visit(ExpressionStatement s);
}