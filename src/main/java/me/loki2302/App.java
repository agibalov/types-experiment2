package me.loki2302;

import java.util.Arrays;

import me.loki2302.compiler.CompilingDOMExpressionVisitor;
import me.loki2302.compiler.DOMExpressionCompiler;
import me.loki2302.compiler.DefaultImplicitCastor;
import me.loki2302.compiler.OperationRepository;
import me.loki2302.dom.DOMAddExpression;
import me.loki2302.dom.DOMDoubleLiteralExpression;
import me.loki2302.dom.DOMExpression;
import me.loki2302.dom.DOMIntLiteralExpression;
import me.loki2302.expressions.DoubleConstExpression;
import me.loki2302.expressions.Expression;
import me.loki2302.expressions.IntConstExpression;
import me.loki2302.operations.AddDoublesOperation;
import me.loki2302.operations.AddIntsOperation;
import me.loki2302.operations.CastDoubleToIntOperation;
import me.loki2302.operations.CastIntToDoubleOperation;
import me.loki2302.operations.Intention;
import me.loki2302.operations.Operation;

public class App {
    public static void main(String[] args) {
        Type intType = new Type("int");
        Type doubleType = new Type("double");
        
        OperationRepository operationRepository = new OperationRepository();
        operationRepository.addOperation(new AddIntsOperation(intType));
        operationRepository.addOperation(new AddDoublesOperation(doubleType));
        operationRepository.addOperation(new CastDoubleToIntOperation(doubleType, intType));
        
        Operation castIntToDoubleOperation = new CastIntToDoubleOperation(intType, doubleType);
        operationRepository.addOperation(castIntToDoubleOperation);        
        
        DefaultImplicitCastor implicitCastor = new DefaultImplicitCastor();
        implicitCastor.allowImplicitCast(intType, doubleType, castIntToDoubleOperation);
        
        Expression expression = operationRepository.process(Intention.Add, Arrays.<Expression>asList(
                new IntConstExpression(intType), 
                new DoubleConstExpression(doubleType)), implicitCastor);
        System.out.println(expression);
        
        CompilingDOMExpressionVisitor compilingDomExpressionVisitor = new CompilingDOMExpressionVisitor(
                intType, 
                doubleType, 
                operationRepository, 
                implicitCastor);
        DOMExpressionCompiler domExpressionCompiler = new DOMExpressionCompiler(compilingDomExpressionVisitor);
        
        DOMExpression domExpression = new DOMAddExpression(
                new DOMIntLiteralExpression(), 
                new DOMDoubleLiteralExpression());
        Expression expression2 = domExpressionCompiler.compile(domExpression);
        System.out.println(expression2);
    }
}
