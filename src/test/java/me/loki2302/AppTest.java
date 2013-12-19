package me.loki2302;

import static org.junit.Assert.*;

import java.util.Arrays;

import me.loki2302.App.DefaultImplicitCastor;
import me.loki2302.App.ImplicitCastor;
import me.loki2302.App.OperationInvoker;
import me.loki2302.App.OperationMatch;
import me.loki2302.App.OperationRepository;
import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.operations.Intention;

import org.junit.Test;

public class AppTest {
    private final static Type intType = new Type("int");
    private final static Type doubleType = new Type("double");    
    
    @Test
    public void dummy() {                
        assertTrue(run(new IntConstExpression(intType), new IntConstExpression(intType)).contains("AddIntsOp,p=[P{0,iconst}, P{0,iconst}]"));
        assertTrue(run(new IntConstExpression(intType), new DoubleConstExpression(doubleType)).contains("AddDoublesOp,p=[P{1,i2d(iconst)}, P{0,dconst}]"));
        assertTrue(run(new DoubleConstExpression(doubleType), new DoubleConstExpression(doubleType)).contains("AddDoublesOp,p=[P{0,dconst}, P{0,dconst}]"));
        assertTrue(run(new DoubleConstExpression(doubleType), new IntConstExpression(intType)).contains("AddDoublesOp,p=[P{0,dconst}, P{1,i2d(iconst)}]"));
    }
    
    private String run(Expression left, Expression right) {
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(new CastIntToDoubleOperation(intType, doubleType));
        operationRepository.addOperation(new CastDoubleToIntOperation(doubleType, intType));
        
        OperationInvoker operationInvoker = new OperationInvoker();
        ImplicitCastor implicitCastor = new DefaultImplicitCastor(operationRepository, operationInvoker);
        OperationMatch operationMatch = operationRepository.findOperation(implicitCastor, Intention.Add, Arrays.<Expression>asList(
                left, 
                right));
        System.out.println(operationMatch);
        
        return operationMatch.toString();
    }
}