package me.loki2302.syntax.dom;

import me.loki2302.syntax.dom.expressions.DOMExpression;
import me.loki2302.syntax.dom.functions.DOMFunctionDefinition;
import me.loki2302.syntax.dom.functions.DOMParameterDefinition;
import me.loki2302.syntax.dom.programs.DOMProgram;
import me.loki2302.syntax.dom.statements.DOMStatement;
import me.loki2302.syntax.dom.types.DOMTypeReference;

public interface DOMElementVisitor<TResult> {
    TResult visit(DOMTypeReference t);
    TResult visit(DOMExpression e);
    TResult visit(DOMStatement s);
    TResult visit(DOMFunctionDefinition f);
    TResult visit(DOMParameterDefinition p);
    TResult visit(DOMProgram p);
}