package me.loki2302.semantics.operations.constraints;

import java.util.List;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.statements.Statement;

public class ArgumentIsListOfStatementsArgumentConstraint implements ArgumentConstraint {
    @Override
    public ConstrainedArgumentResult test(Compiler compiler, Object argument) {        
        if(!(argument instanceof List)) {
            return ConstrainedArgumentResult.fail();
        }
        
        List<?> list = (List<?>)argument;
        for(Object o : list) {
            if(!(o instanceof Statement)) {
                return ConstrainedArgumentResult.fail();
            }
        }
        
        return ConstrainedArgumentResult.ok(0, argument);            
    }        
}