package me.loki2302.generator;

import me.loki2302.semantics.expressions.AddDoublesExpression;
import me.loki2302.semantics.expressions.AddIntsExpression;
import me.loki2302.semantics.expressions.CastDoubleToIntExpression;
import me.loki2302.semantics.expressions.CastIntToDoubleExpression;
import me.loki2302.semantics.expressions.DoubleConstExpression;
import me.loki2302.semantics.expressions.ExpressionVisitor;
import me.loki2302.semantics.expressions.IntConstExpression;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

public class InsnListGeneratingExpressionVisitor implements ExpressionVisitor<InsnList> {
    @Override
    public InsnList visit(AddDoublesExpression e) {
        InsnList leftExpressionInsnList = e.getLeftExpression().accept(this);
        InsnList rightExpressionInsnList = e.getRightExpression().accept(this);
        InsnList insnList = new InsnList();
        insnList.add(leftExpressionInsnList);
        insnList.add(rightExpressionInsnList);                
        insnList.add(new InsnNode(Opcodes.DADD));
        return insnList;
    }

    @Override
    public InsnList visit(AddIntsExpression e) {
        InsnList leftExpressionInsnList = e.getLeftExpression().accept(this);
        InsnList rightExpressionInsnList = e.getRightExpression().accept(this);
        InsnList insnList = new InsnList();
        insnList.add(leftExpressionInsnList);
        insnList.add(rightExpressionInsnList);                
        insnList.add(new InsnNode(Opcodes.IADD));
        return insnList;
    }

    @Override
    public InsnList visit(CastDoubleToIntExpression e) {
        InsnList expressionInsnList = e.getExpression().accept(this);
        InsnList insnList = new InsnList();
        insnList.add(expressionInsnList);
        insnList.add(new InsnNode(Opcodes.D2I));                
        return insnList;
    }

    @Override
    public InsnList visit(CastIntToDoubleExpression e) {
        InsnList expressionInsnList = e.getExpression().accept(this);
        InsnList insnList = new InsnList();
        insnList.add(expressionInsnList);
        insnList.add(new InsnNode(Opcodes.I2D));                
        return insnList;
    }

    @Override
    public InsnList visit(IntConstExpression e) {       
        String valueString = e.getValue();
        int value = Integer.valueOf(valueString);
        InsnList insnList = new InsnList();
        insnList.add(new LdcInsnNode(value));                
        return insnList;
    }

    @Override
    public InsnList visit(DoubleConstExpression e) {
        String valueString = e.getValue();
        double value = Double.valueOf(valueString);                
        InsnList insnList = new InsnList();
        insnList.add(new LdcInsnNode(value));                
        return insnList;
    }
}