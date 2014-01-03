package me.loki2302;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.OperationRepository;
import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.operations.AddDoublesOperation;
import me.loki2302.semantics.operations.AddIntsOperation;
import me.loki2302.semantics.operations.CastDoubleToIntOperation;
import me.loki2302.semantics.operations.CastIntToDoubleOperation;
import me.loki2302.semantics.operations.MakeCompositeStatementOperation;
import me.loki2302.semantics.operations.MakeDoubleConstExpressionOperation;
import me.loki2302.semantics.operations.MakeExpressionStatementOperation;
import me.loki2302.semantics.operations.MakeFunctionOperation;
import me.loki2302.semantics.operations.MakeIntConstExpressionOperation;
import me.loki2302.semantics.statements.Statement;
import me.loki2302.semantics.types.PrimitiveType;
import me.loki2302.semantics.types.Type;
import me.loki2302.syntax.ParseResult;
import me.loki2302.syntax.Parser;
import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.statements.DOMStatement;

public class CompilerFacade {
    private final Parser parser;
    private final CompilingDOMExpressionVisitor compilingDOMExpressionVisitor;
    private final CompilingDOMStatementVisitor compilingDOMStatementVisitor;
    
    public CompilerFacade(
            Parser parser, 
            CompilingDOMExpressionVisitor compilingDOMExpressionVisitor,
            CompilingDOMStatementVisitor compilingDOMStatementVisitor) {
        
        this.parser = parser;
        this.compilingDOMExpressionVisitor = compilingDOMExpressionVisitor;
        this.compilingDOMStatementVisitor = compilingDOMStatementVisitor;
    }
    
    public Expression compileExpression(String expressionString) {
        ParseResult parseResult = parser.parseExpression(expressionString);
        if(!parseResult.isOk()) {
            throw new RuntimeException("Failed to parse");
        }
        
        DOMExpression domExpression = (DOMExpression)parseResult.getDOMElement();
        return domExpression.accept(compilingDOMExpressionVisitor); 
    }
    
    public Statement compileStatement(String statementString) {
        ParseResult parseResult = parser.parsePureStatement(statementString);
        if(!parseResult.isOk()) {
            throw new RuntimeException("Failed to parse");
        }
                
        DOMStatement domStatement = (DOMStatement)parseResult.getDOMElement();
        return domStatement.accept(compilingDOMStatementVisitor);
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
        operationRepository.addOperation(new MakeExpressionStatementOperation());
        operationRepository.addOperation(new MakeCompositeStatementOperation());        
        operationRepository.addOperation(new MakeFunctionOperation());
        
        Compiler compiler = new Compiler(operationRepository, implicitCastOperationRepository);
        CompilingDOMExpressionVisitor compilingDOMExpressionVisitor = new CompilingDOMExpressionVisitor(compiler);
        CompilingDOMStatementVisitor compilingDOMStatementVisitor = new CompilingDOMStatementVisitor(compiler, compilingDOMExpressionVisitor);
        
        return new CompilerFacade(parser, compilingDOMExpressionVisitor, compilingDOMStatementVisitor);
    }
}