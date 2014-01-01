package me.loki2302;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.requests.MakeDoubleConstExpressionRequest;
import me.loki2302.semantics.requests.MakeIntConstExpressionRequest;
import me.loki2302.semantics.requests.MakeOperatorAddExpressionRequest;
import me.loki2302.syntax.dom.DOMExpressionVisitor;
import me.loki2302.syntax.dom.DoubleLiteralDOMExpression;
import me.loki2302.syntax.dom.IntLiteralDOMExpression;
import me.loki2302.syntax.dom.OperatorAddDOMExpression;

public class CompilingDOMExpressionVisitor implements DOMExpressionVisitor<Expression> {
    private final Compiler compiler;
    
    public CompilingDOMExpressionVisitor(Compiler compiler) {
        this.compiler = compiler;
    }
    
    @Override
    public Expression visit(IntLiteralDOMExpression e) {
        return compiler.compile(new MakeIntConstExpressionRequest(e.getLiteralString()));
    }

    @Override
    public Expression visit(DoubleLiteralDOMExpression e) {
        return compiler.compile(new MakeDoubleConstExpressionRequest(e.getLiteralString()));
    }

    @Override
    public Expression visit(OperatorAddDOMExpression e) {
        Expression leftExpression = e.getLeftExpression().accept(this);
        Expression rightExpression = e.getRightExpression().accept(this);
        return compiler.compile(new MakeOperatorAddExpressionRequest(leftExpression, rightExpression));
    }
}