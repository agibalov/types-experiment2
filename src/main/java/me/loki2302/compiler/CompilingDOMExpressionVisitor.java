package me.loki2302.compiler;

import java.util.Arrays;

import me.loki2302.Type;
import me.loki2302.dom.DOMAddExpression;
import me.loki2302.dom.DOMDoubleLiteralExpression;
import me.loki2302.dom.DOMExpressionVisitor;
import me.loki2302.dom.DOMIntLiteralExpression;
import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.Intention;

public class CompilingDOMExpressionVisitor implements DOMExpressionVisitor<Expression> {
    private final Type intType;
    private final Type doubleType;
    private final OperationRepository operationRepository;
    private final ImplicitCastor implicitCastor;
    
    public CompilingDOMExpressionVisitor(
            Type intType, 
            Type doubleType, 
            OperationRepository operationRepository, 
            ImplicitCastor implicitCastor) {
        this.intType = intType;
        this.doubleType = doubleType;
        this.operationRepository = operationRepository;
        this.implicitCastor = implicitCastor;
    }

    @Override
    public Expression visit(DOMIntLiteralExpression e) {
        // TODO: replace this with call to operation
        return new IntConstExpression(intType);
    }

    @Override
    public Expression visit(DOMDoubleLiteralExpression e) {
        // TODO: replace this with call to operation
        return new DoubleConstExpression(doubleType);
    }

    @Override
    public Expression visit(DOMAddExpression e) {
        Expression leftExpression = e.getLeftExpression().accept(this);
        Expression rightExpression = e.getRightExpression().accept(this);            
        return process(Intention.Add, leftExpression, rightExpression);
    }
    
    private Expression process(Intention intention, Expression... arguments) {
        return operationRepository.process(intention, Arrays.asList(arguments), implicitCastor);
    }
}