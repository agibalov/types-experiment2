package me.loki2302.generator;

import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.statements.Statement;
import me.loki2302.semantics.types.PrimitiveType;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class JavaAppClassGenerator {
    private final InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor;
    private final InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor;
    
    public JavaAppClassGenerator(
            InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor,
            InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor) {
        this.insnListGeneratingExpressionVisitor = insnListGeneratingExpressionVisitor;
        this.insnListGeneratingStatementVisitor = insnListGeneratingStatementVisitor;
    }
    
    public byte[] generateBytecode(Statement statement) {
        MethodNode mainMethodNode = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mainMethodNode.instructions.add(statement.accept(insnListGeneratingStatementVisitor));        
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
        InsnList expressionInsnList = expression.accept(insnListGeneratingExpressionVisitor);
        
        MethodNode mainMethodNode = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mainMethodNode.instructions.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
        mainMethodNode.instructions.add(expressionInsnList);        
        
        // dirty hack
        if(((PrimitiveType)expression.getType()).getTypeName().equals("int")) {
            mainMethodNode.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V"));
        } else {
            mainMethodNode.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V"));
        }
        
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
    
    public static JavaAppClassGenerator makeDefault() {
        InsnListGeneratingExpressionVisitor insnListGeneratingExpressionVisitor = 
                new InsnListGeneratingExpressionVisitor();
        InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor = 
                new InsnListGeneratingStatementVisitor(insnListGeneratingExpressionVisitor);
        JavaAppClassGenerator javaAppClassGenerator = new JavaAppClassGenerator(
                insnListGeneratingExpressionVisitor, 
                insnListGeneratingStatementVisitor);
        return javaAppClassGenerator;
    }
}