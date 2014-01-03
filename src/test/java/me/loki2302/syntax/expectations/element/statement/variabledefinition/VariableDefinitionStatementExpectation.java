package me.loki2302.syntax.expectations.element.statement.variabledefinition;

import me.loki2302.syntax.dom.statements.DOMVariableDefinitionStatement;

public interface VariableDefinitionStatementExpectation {
    void check(DOMVariableDefinitionStatement domVariableDefinitionStatement);
}