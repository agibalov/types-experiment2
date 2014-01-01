package me.loki2302;

import static org.junit.Assert.*;
import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.operations.MakeDoubleConstExpressionOperation;
import me.loki2302.operations.MakeIntConstExpressionOperation;
import me.loki2302.requests.MakeDoubleConstExpressionRequest;
import me.loki2302.requests.MakeIntConstExpressionRequest;
import me.loki2302.requests.MakeOperatorAddExpressionRequest;
import me.loki2302.requests.MakeOperatorCastExpressionRequest;
import me.loki2302.requests.Request;
import me.loki2302.types.PrimitiveType;
import me.loki2302.types.Type;

import org.junit.Test;

public class TypeSystemTest {
    private final static Type intType = new PrimitiveType("int");
    private final static Type doubleType = new PrimitiveType("double");
    private final static Compiler compiler = makeCompiler();
    
    @Test
    public void canMakeIntConst() {
        String result = compile(new MakeIntConstExpressionRequest("1"));
        assertEquals("iconst(1)", result);
    }
    
    @Test
    public void canMakeDoubleConst() {
        String result = compile(new MakeDoubleConstExpressionRequest("1"));
        assertEquals("dconst(1)", result);
    }
    
    @Test
    public void testIntAddInt() {
        Expression a = new IntConstExpression(intType, "1");
        Expression b = new IntConstExpression(intType, "2");
        String result = compile(new MakeOperatorAddExpressionRequest(a, b));
        assertEquals("iadd(iconst(1),iconst(2))", result);
    }
    
    @Test
    public void testDoubleAddDouble() {
        Expression a = new DoubleConstExpression(doubleType, "1");
        Expression b = new DoubleConstExpression(doubleType, "2");
        String result = compile(new MakeOperatorAddExpressionRequest(a, b));
        assertEquals("dadd(dconst(1),dconst(2))", result);
    }
    
    @Test
    public void testIntAddDouble() {
        Expression a = new IntConstExpression(intType, "1");
        Expression b = new DoubleConstExpression(doubleType, "2");
        String result = compile(new MakeOperatorAddExpressionRequest(a, b));
        assertEquals("dadd(i2d(iconst(1)),dconst(2))", result);
    }
    
    @Test
    public void testCastIntToDouble() {
        Expression e = new IntConstExpression(intType, "1");
        String result = compile(new MakeOperatorCastExpressionRequest(doubleType, e));
        assertEquals("i2d(iconst(1))", result);
    }
    
    @Test
    public void testCastDoubleToInt() {
        Expression e = new DoubleConstExpression(doubleType, "1");
        String result = compile(new MakeOperatorCastExpressionRequest(intType, e));
        assertEquals("d2i(dconst(1))", result);
    }
    
    @Test
    public void testCastIntToInt() {
        Expression e = new IntConstExpression(intType, "1");
        String result = compile(new MakeOperatorCastExpressionRequest(intType, e));
        assertEquals("null", result);
    }
    
    @Test
    public void testCastDoubleToDouble() {        
        Expression e = new DoubleConstExpression(doubleType, "1");
        String result = compile(new MakeOperatorCastExpressionRequest(doubleType, e));
        assertEquals("null", result);
    }
    
    private static <TResult> String compile(Request<TResult> request) {
        TResult result = compiler.compile(request);
        return String.valueOf(result);
    }
    
    private static Compiler makeCompiler() {                
        CastIntToDoubleOperation castIntToDoubleOperation = new CastIntToDoubleOperation(doubleType, intType);
        OperationRepository implicitCastOperationRepository = new OperationRepository();
        implicitCastOperationRepository.addOperation(castIntToDoubleOperation);
        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(castIntToDoubleOperation);
        operationRepository.addOperation(new CastDoubleToIntOperation(intType, doubleType));
        operationRepository.addOperation(new MakeIntConstExpressionOperation(intType));
        operationRepository.addOperation(new MakeDoubleConstExpressionOperation(doubleType));
        
        Compiler compiler = new Compiler(operationRepository, implicitCastOperationRepository);
        return compiler;
    }
}