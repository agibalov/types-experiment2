package me.loki2302.semantics.statements;


public interface Statement {        
    <TResult> TResult accept(StatementVisitor<TResult> visitor);
}