package me.loki2302.generator;

import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.statements.ExpressionStatement;
import me.loki2302.semantics.statements.Statement;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class JavaAppClassGenerator {
    private final StatementCodeGenerator statementCodeGenerator;
    
    public JavaAppClassGenerator(StatementCodeGenerator statementCodeGenerator) {
        this.statementCodeGenerator = statementCodeGenerator;
    }
    
    public byte[] generateBytecode(Statement statement) {
        MethodNode mainMethodNode = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mainMethodNode.instructions.add(statementCodeGenerator.generateCode(statement));        
        mainMethodNode.instructions.add(new InsnNode(Opcodes.RETURN));       
        
        ClassNode classNode = new ClassNode();
        classNode.version = Opcodes.V1_5;
        classNode.access = Opcodes.ACC_PUBLIC;
        classNode.name = "NewApp";
        classNode.superName = "java/lang/Object";
        classNode.methods.add(mainMethodNode);
        
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        
        return classWriter.toByteArray();
    }
    
    public byte[] generateBytecode(Expression expression) {
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        return generateBytecode(expressionStatement);
    }
    
    public static JavaAppClassGenerator makeDefault() {
        InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor = 
                new InsnListGeneratingExpressionVisitor();
        ExpressionCodeGenerator expressionCodeGenerator = new ExpressionCodeGenerator(
                insnListGeneratingExpressionVisitor);
        
        InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor = 
                new InsnListGeneratingStatementVisitor(expressionCodeGenerator);
        StatementCodeGenerator statementCodeGenerator = new StatementCodeGenerator(
                insnListGeneratingStatementVisitor);        
        
        JavaAppClassGenerator javaAppClassGenerator = new JavaAppClassGenerator(statementCodeGenerator);
        return javaAppClassGenerator;
    }
}