package me.loki2302;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.OperationRepository;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.operations.AddDoublesOperation;
import me.loki2302.semantics.operations.AddIntsOperation;
import me.loki2302.semantics.operations.CastDoubleToIntOperation;
import me.loki2302.semantics.operations.CastIntToDoubleOperation;
import me.loki2302.semantics.operations.MakeDoubleConstExpressionOperation;
import me.loki2302.semantics.operations.MakeIntConstExpressionOperation;
import me.loki2302.semantics.requests.MakeDoubleConstExpressionRequest;
import me.loki2302.semantics.requests.MakeIntConstExpressionRequest;
import me.loki2302.semantics.requests.MakeOperatorAddExpressionRequest;
import me.loki2302.semantics.types.PrimitiveType;
import me.loki2302.semantics.types.Type;
import me.loki2302.syntax.DOMExpression;
import me.loki2302.syntax.DOMExpressionVisitor;
import me.loki2302.syntax.DoubleLiteralDOMExpression;
import me.loki2302.syntax.IntLiteralDOMExpression;
import me.loki2302.syntax.OperatorAddDOMExpression;
import me.loki2302.syntax.Parser;

public class CompilerFacade {
    private final Parser parser;
    private final Compiler compiler;
    
    public CompilerFacade(Parser parser, Compiler compiler) {
        this.parser = parser;
        this.compiler = compiler;
    }
    
    public Expression compile(String expressionString) {
        DOMExpression domExpression = parser.parse(expressionString);
        return domExpression.accept(new DOMExpressionVisitor<Expression>() {
            @Override
            public Expression visit(IntLiteralDOMExpression e) {
                return compiler.compile(new MakeIntConstExpressionRequest(e.getLiteralString()));
            }

            @Override
            public Expression visit(DoubleLiteralDOMExpression e) {
                return compiler.compile(new MakeDoubleConstExpressionRequest(e.getLiteralString()));
            }

            @Override
            public Expression visit(OperatorAddDOMExpression e) {
                Expression leftExpression = e.getLeftExpression().accept(this);
                Expression rightExpression = e.getRightExpression().accept(this);
                return compiler.compile(new MakeOperatorAddExpressionRequest(leftExpression, rightExpression));
            }
        }); 
    }
    
    public static CompilerFacade makeDefault() {
        Parser parser = new Parser();
        
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
        operationRepository.addOperation(new MakeIntConstExpressionOperation(intType));
        operationRepository.addOperation(new MakeDoubleConstExpressionOperation(doubleType));
        
        Compiler compiler = new Compiler(operationRepository, implicitCastOperationRepository);
        
        return new CompilerFacade(parser, compiler);
    }
}