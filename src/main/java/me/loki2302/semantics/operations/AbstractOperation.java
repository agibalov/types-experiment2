package me.loki2302.semantics.operations;

import java.util.ArrayList;
import java.util.List;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.operations.constraints.ArgumentConstraint;
import me.loki2302.semantics.operations.constraints.ConstrainedArgumentResult;

public abstract class AbstractOperation implements Operation {
    @Override
    public OperationResult process(Compiler compiler, List<Object> arguments) {
        int requiredArgumentCount = getArgumentCount();
        if(arguments.size() != requiredArgumentCount) {
            return OperationResult.fail();
        }
        
        int totalScore = 0;
        List<Object> safeArguments = new ArrayList<Object>();
        for(int i = 0; i < requiredArgumentCount; ++i) {
            ArgumentConstraint argumentConstraint = getArgumentConstraint(i);
            Object argument = arguments.get(i);
            ConstrainedArgumentResult constrainedArgumentResult = argumentConstraint.test(compiler, argument);
            if(!constrainedArgumentResult.ok) {
                return OperationResult.fail();
            }
            
            totalScore += constrainedArgumentResult.score;
            safeArguments.add(constrainedArgumentResult.constrainedArgument);
        }
        
        Object result = processSafe(safeArguments);
        return OperationResult.ok(totalScore, result);
    }
    
    protected abstract int getArgumentCount();
    protected abstract ArgumentConstraint getArgumentConstraint(int index);
    protected abstract Object processSafe(List<Object> safeArguments);
}