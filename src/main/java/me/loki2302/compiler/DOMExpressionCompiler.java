package me.loki2302.compiler;

import me.loki2302.dom.DOMExpression;
import me.loki2302.expressions.Expression;

public class DOMExpressionCompiler {
    private final CompilingDOMExpressionVisitor compilingDomExpressionVisitor;
    
    public DOMExpressionCompiler(CompilingDOMExpressionVisitor compilingDomExpressionVisitor) {
        this.compilingDomExpressionVisitor = compilingDomExpressionVisitor; 
    }
    
    public Expression compile(DOMExpression domExpression) {
        return domExpression.accept(compilingDomExpressionVisitor);
    }
}