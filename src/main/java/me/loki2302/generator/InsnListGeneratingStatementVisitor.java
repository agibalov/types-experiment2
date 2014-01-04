package me.loki2302.generator;

import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.statements.CompositeStatement;
import me.loki2302.semantics.statements.ExpressionStatement;
import me.loki2302.semantics.statements.Statement;
import me.loki2302.semantics.statements.StatementVisitor;
import me.loki2302.semantics.types.PrimitiveType;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;

public class InsnListGeneratingStatementVisitor implements StatementVisitor<InsnList> {
    private final ExpressionCodeGenerator expressionCodeGenerator;
    
    public InsnListGeneratingStatementVisitor(ExpressionCodeGenerator expressionCodeGenerator) {
        this.expressionCodeGenerator = expressionCodeGenerator;
    }
    
    @Override
    public InsnList visit(CompositeStatement s) {
        InsnList insnList = new InsnList();
        for(Statement statement : s.getStatements()) {
            insnList.add(statement.accept(this));
        }
        
        return insnList;
    }

    @Override
    public InsnList visit(ExpressionStatement s) {
        Expression expression = s.getExpression();
        
        InsnList insnList = new InsnList();
        insnList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
        insnList.add(expressionCodeGenerator.generateCode(expression));
        
        // dirty hack
        if(((PrimitiveType)expression.getType()).getTypeName().equals("int")) {
            insnList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V"));
        } else {
            insnList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V"));
        }
        
        return insnList;
    }        
}