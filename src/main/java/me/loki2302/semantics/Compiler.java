package me.loki2302.semantics;

import me.loki2302.semantics.expressions.Expression;
import me.loki2302.semantics.requests.MakeOperatorCastExpressionRequest;
import me.loki2302.semantics.requests.Request;
import me.loki2302.semantics.types.Type;

public class Compiler {
    private final OperationRepository operationRepository;
    private final OperationRepository implicitCastOperationRepository;
    
    public Compiler(
            OperationRepository operationRepository, 
            OperationRepository implicitCastOperationRepository) {
        this.operationRepository = operationRepository;
        this.implicitCastOperationRepository = implicitCastOperationRepository;
    }
    
    public <TResult> TResult compile(Request<TResult> request) {
        return operationRepository.call(this, request);
    }
    
    public Expression castImplicitly(Type targetType, Expression expression) {
        return implicitCastOperationRepository.call(this, new MakeOperatorCastExpressionRequest(targetType, expression));
    }
}