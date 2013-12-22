package me.loki2302.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.loki2302.Type;
import me.loki2302.expressions.Expression;
import me.loki2302.operations.ExpressionResult;
import me.loki2302.operations.Operation;

public class DefaultImplicitCastor implements ImplicitCastor {
    private final List<DefaultImplicitCastor.ImplicitCast> implicitCasts = new ArrayList<DefaultImplicitCastor.ImplicitCast>();
    
    public void allowImplicitCast(Type fromType, Type toType, Operation implicitCastOperation) {
        DefaultImplicitCastor.ImplicitCast implicitCast = new ImplicitCast();
        implicitCast.fromType = fromType;
        implicitCast.toType = toType;
        implicitCast.implicitCastOperation = implicitCastOperation;
        implicitCasts.add(implicitCast);
    }
    
    @Override
    public Expression wrapWithImplicitCast(Type desiredType, Expression e) {
        Type sourceType = e.getResultType();
        for(DefaultImplicitCastor.ImplicitCast implicitCast : implicitCasts) {
            if(!implicitCast.fromType.equals(sourceType)) {
                continue;
            }
            
            if(!implicitCast.toType.equals(desiredType)) {
                continue;
            }
            
            ExpressionResult expressionResult = implicitCast.implicitCastOperation.process(
                    new NullImplicitCastor(), 
                    Arrays.<Expression>asList(e));
            return expressionResult.expression;
        }
                    
        return null;
    }
    
    private static class ImplicitCast {
        public Type fromType;
        public Type toType;
        public Operation implicitCastOperation;
    }
}