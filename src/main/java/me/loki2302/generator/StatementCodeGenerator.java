package me.loki2302.generator;

import me.loki2302.semantics.statements.Statement;

import org.objectweb.asm.tree.InsnList;

public class StatementCodeGenerator {
    private InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor;
    
    public StatementCodeGenerator(InsnListGeneratingStatementVisitor insnListGeneratingStatementVisitor) {
        this.insnListGeneratingStatementVisitor = insnListGeneratingStatementVisitor;
    }
    
    public InsnList generateCode(Statement statement) {
        return statement.accept(insnListGeneratingStatementVisitor);
    }
}