package me.loki2302.semantics.operations;

public class OperationResult {
    public boolean ok;
    public int score;
    public Object result;
    
    public static OperationResult ok(int score, Object result) {
        OperationResult operationResult = new OperationResult();
        operationResult.ok = true;
        operationResult.score = score;
        operationResult.result = result;
        return operationResult;
    }
    
    public static OperationResult fail() {
        OperationResult operationResult = new OperationResult();
        operationResult.ok = false;
        return operationResult;
    }
}