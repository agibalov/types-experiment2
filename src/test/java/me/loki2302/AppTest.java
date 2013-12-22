package me.loki2302;

import static org.junit.Assert.*;

import java.util.Arrays;

import me.loki2302.compiler.DefaultImplicitCastor;
import me.loki2302.compiler.OperationRepository;
import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.operations.Intention;
import me.loki2302.operations.Operation;

import org.junit.Test;

public class AppTest {
    private final static Type intType = new Type("int");
    private final static Type doubleType = new Type("double");
    
    @Test
    public void dummy() {
        assertEquals("iadd(iconst,iconst)", run(new IntConstExpression(intType), new IntConstExpression(intType)));
        assertEquals("dadd(dconst,dconst)", run(new DoubleConstExpression(doubleType), new DoubleConstExpression(doubleType)));
        assertEquals("dadd(dconst,i2d(iconst))", run(new DoubleConstExpression(doubleType), new IntConstExpression(intType)));
        assertEquals("dadd(i2d(iconst),dconst)", run(new IntConstExpression(intType), new DoubleConstExpression(doubleType)));
    }
    
    private String run(Expression left, Expression right) {        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(new CastDoubleToIntOperation(doubleType, intType));
        
        Operation castIntToDoubleOperation = new CastIntToDoubleOperation(intType, doubleType);
        operationRepository.addOperation(castIntToDoubleOperation);        
        
        DefaultImplicitCastor implicitCastor = new DefaultImplicitCastor();
        implicitCastor.allowImplicitCast(intType, doubleType, castIntToDoubleOperation);
        
        Expression expression = operationRepository.process(
                Intention.Add, 
                Arrays.<Expression>asList(left, right), 
                implicitCastor);
        System.out.println(expression);
                        
        return expression.toString();
    }
}