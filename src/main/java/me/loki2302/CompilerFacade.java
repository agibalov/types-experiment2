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
import me.loki2302.semantics.types.PrimitiveType;
import me.loki2302.semantics.types.Type;
import me.loki2302.syntax.ParseResult;
import me.loki2302.syntax.Parser;
import me.loki2302.syntax.dom.expressions.DOMExpression;

public class CompilerFacade {
    private final Parser parser;
    private final CompilingDOMExpressionVisitor compilingDOMExpressionVisitor;
    
    public CompilerFacade(Parser parser, CompilingDOMExpressionVisitor compilingDOMExpressionVisitor) {
        this.parser = parser;
        this.compilingDOMExpressionVisitor = compilingDOMExpressionVisitor;
    }
    
    public Expression compile(String expressionString) {
        ParseResult parseResult = parser.parseExpression(expressionString);
        if(!parseResult.isOk()) {
            throw new RuntimeException("Failed to parse");
        }
        
        DOMExpression domExpression = (DOMExpression)parseResult.getDOMElement();
        return domExpression.accept(compilingDOMExpressionVisitor); 
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
        CompilingDOMExpressionVisitor compilingDOMExpressionVisitor = new CompilingDOMExpressionVisitor(compiler);
        
        return new CompilerFacade(parser, compilingDOMExpressionVisitor);
    }
}