package me.loki2302;

import me.loki2302.semantics.statements.Statement;
import me.loki2302.syntax.dom.statements.DOMBreakStatement;
import me.loki2302.syntax.dom.statements.DOMCompositeStatement;
import me.loki2302.syntax.dom.statements.DOMContinueStatement;
import me.loki2302.syntax.dom.statements.DOMDoWhileStatement;
import me.loki2302.syntax.dom.statements.DOMExpressionStatement;
import me.loki2302.syntax.dom.statements.DOMForStatement;
import me.loki2302.syntax.dom.statements.DOMIfStatement;
import me.loki2302.syntax.dom.statements.DOMNullStatement;
import me.loki2302.syntax.dom.statements.DOMReturnStatement;
import me.loki2302.syntax.dom.statements.DOMStatementVisitor;
import me.loki2302.syntax.dom.statements.DOMVariableDefinitionStatement;
import me.loki2302.syntax.dom.statements.DOMWhileStatement;

public class CompilingDOMStatementVisitor implements DOMStatementVisitor<Statement> {
    @Override
    public Statement visit(DOMBreakStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMCompositeStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMForStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMIfStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMExpressionStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMDoWhileStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMWhileStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMReturnStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMNullStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMVariableDefinitionStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMContinueStatement s) {
        throw new RuntimeException("Not implemented");
    }        
}