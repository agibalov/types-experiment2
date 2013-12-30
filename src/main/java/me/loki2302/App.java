package me.loki2302;

import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.requests.MakeOperatorAddExpressionRequest;
import me.loki2302.requests.MakeOperatorCastExpressionRequest;
import me.loki2302.types.PrimitiveType;
import me.loki2302.types.Type;


public class App {
    public static void main(String[] args) {
        Type intType = new PrimitiveType("int");
        Type doubleType = new PrimitiveType("double");
                
        CastIntToDoubleOperation castIntToDoubleOperation = new CastIntToDoubleOperation(doubleType, intType);
        OperationRepository implicitCastOperationRepository = new OperationRepository();
        implicitCastOperationRepository.addOperation(castIntToDoubleOperation);
        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(castIntToDoubleOperation);
        operationRepository.addOperation(new CastDoubleToIntOperation(intType, doubleType));
        
        Compiler compiler = new Compiler(operationRepository, implicitCastOperationRepository);

        if(true) {
            Expression a = new IntConstExpression(intType, "1");
            Expression b = new IntConstExpression(intType, "2");
            Expression sum = compiler.compile(new MakeOperatorAddExpressionRequest(a, b));
            System.out.println(sum);
        }
        
        if(true) {
            Expression a = new DoubleConstExpression(doubleType, "1");
            Expression b = new DoubleConstExpression(doubleType, "2");
            Expression sum = compiler.compile(new MakeOperatorAddExpressionRequest(a, b));
            System.out.println(sum);
        }
        
        if(true) {
            Expression a = new IntConstExpression(intType, "1");
            Expression b = new DoubleConstExpression(doubleType, "2");
            Expression sum = compiler.compile(new MakeOperatorAddExpressionRequest(a, b));
            System.out.println(sum);
        }
        
        if(true) {
            Expression e = new IntConstExpression(intType, "1");
            Expression cast = compiler.compile(new MakeOperatorCastExpressionRequest(doubleType, e));
            System.out.println(cast);
        }
        
        if(true) {
            Expression e = new DoubleConstExpression(doubleType, "1");
            Expression cast = compiler.compile(new MakeOperatorCastExpressionRequest(intType, e));
            System.out.println(cast);
        }
        
        if(true) {
            Expression e = new IntConstExpression(intType, "1");
            Expression cast = compiler.compile(new MakeOperatorCastExpressionRequest(intType, e));
            System.out.println(cast);
        }
        
        if(true) {
            Expression e = new DoubleConstExpression(doubleType, "1");
            Expression cast = compiler.compile(new MakeOperatorCastExpressionRequest(doubleType, e));
            System.out.println(cast);
        }
    }
}
