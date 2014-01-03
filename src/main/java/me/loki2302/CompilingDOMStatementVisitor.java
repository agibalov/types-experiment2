package me.loki2302;

import java.util.ArrayList;
import java.util.List;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.requests.MakeCompositeStatementRequest;
import me.loki2302.semantics.requests.MakeExpressionStatementRequest;
import me.loki2302.semantics.statements.Statement;
import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.statements.DOMBreakStatement;
import me.loki2302.syntax.dom.statements.DOMCompositeStatement;
import me.loki2302.syntax.dom.statements.DOMContinueStatement;
import me.loki2302.syntax.dom.statements.DOMDoWhileStatement;
import me.loki2302.syntax.dom.statements.DOMExpressionStatement;
import me.loki2302.syntax.dom.statements.DOMForStatement;
import me.loki2302.syntax.dom.statements.DOMIfStatement;
import me.loki2302.syntax.dom.statements.DOMNullStatement;
import me.loki2302.syntax.dom.statements.DOMReturnStatement;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.dom.statements.DOMStatementVisitor;
import me.loki2302.syntax.dom.statements.DOMVariableDefinitionStatement;
import me.loki2302.syntax.dom.statements.DOMWhileStatement;

public class CompilingDOMStatementVisitor implements DOMStatementVisitor<Statement> {
    private final Compiler compiler;
    private final CompilingDOMExpressionVisitor expressionVisitor;
    
    public CompilingDOMStatementVisitor(Compiler compiler, CompilingDOMExpressionVisitor expressionVisitor) {
        this.compiler = compiler;
        this.expressionVisitor = expressionVisitor;
    }
    
    @Override
    public Statement visit(DOMBreakStatement s) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Statement visit(DOMCompositeStatement s) {
        List<Statement> statements = new ArrayList<Statement>();
        for(DOMStatement domStatement : s.getStatements()) {
            Statement statement = domStatement.accept(this);
            statements.add(statement);
        }
        
        return compiler.compile(new MakeCompositeStatementRequest(statements));
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
        DOMExpression domExpression = s.getExpression();
        Expression expression = domExpression.accept(expressionVisitor);
        return compiler.compile(new MakeExpressionStatementRequest(expression));
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