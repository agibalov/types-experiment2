package me.loki2302.syntax.dom.statements;


public interface DOMStatementVisitor<TResult> {
    TResult visit(DOMBreakStatement s);
    TResult visit(DOMCompositeStatement s);
    TResult visit(DOMForStatement s);
    TResult visit(DOMIfStatement s);
    TResult visit(DOMExpressionStatement s);
    TResult visit(DOMDoWhileStatement s);
    TResult visit(DOMWhileStatement s);
    TResult visit(DOMReturnStatement s);
    TResult visit(DOMNullStatement s);
    TResult visit(DOMVariableDefinitionStatement s);
    TResult visit(DOMContinueStatement s);
}