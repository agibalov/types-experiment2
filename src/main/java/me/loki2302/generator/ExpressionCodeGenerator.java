package me.loki2302.generator;

import me.loki2302.semantics.expressions.Expression;

import org.objectweb.asm.tree.InsnList;

public class ExpressionCodeGenerator {
    private final InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor;
    
    public ExpressionCodeGenerator(InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor) {
        this.insnListGeneratingExpressionVisitor = insnListGeneratingExpressionVisitor;
    }
    
    public InsnList generateCode(Expression expression) {
        return expression.accept(insnListGeneratingExpressionVisitor);
    }
}