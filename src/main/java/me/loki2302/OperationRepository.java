package me.loki2302;

import java.util.ArrayList;
import java.util.List;

import me.loki2302.operations.Operation;
import me.loki2302.operations.OperationResult;
import me.loki2302.requests.Request;

public class OperationRepository {
    private final List<Operation> operations = new ArrayList<Operation>();
    
    public void addOperation(Operation operation) {
        operations.add(operation);
    }
    
    public <TResult> TResult call(Compiler compiler, Request<TResult> request) {
        List<Object> requestArguments = new ArrayList<Object>();
        for(int i = 0; i < request.getArgumentCount(); ++i) {
            Object argument = request.getArgument(i);
            requestArguments.add(argument);
        }
        
        OperationResult bestOperationResult = null;            
        Intention requestIntention = request.getIntention();
        for(Operation operation : operations) {
            Intention operationIntention = operation.getIntention();
            if(!operationIntention.equals(requestIntention)) {
                continue;
            }
            
            OperationResult operationResult = operation.process(compiler, requestArguments);
            if(!operationResult.ok) {
                continue;
            }
            
            if(bestOperationResult == null) {
                bestOperationResult = operationResult;
                continue;
            }
            
            if(operationResult.score < bestOperationResult.score) {
                bestOperationResult = operationResult;
            }
        }
        
        if(bestOperationResult == null) {
            return null;
        }
        
        return (TResult)bestOperationResult.result;
    }
}