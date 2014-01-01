package me.loki2302.syntax;

import me.loki2302.syntax.dom.DOMExpression;
import me.loki2302.syntax.dom.DoubleLiteralDOMExpression;
import me.loki2302.syntax.dom.IntLiteralDOMExpression;
import me.loki2302.syntax.dom.OperatorAddDOMExpression;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.DoubleLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.visitor.GenericVisitorAdapter;

public class Parser {
    public DOMExpression parse(String expressionString) {
        Expression expression; 
        try {
            expression = JavaParser.parseExpression(expressionString);
        } catch(ParseException e) {
            throw new ParserException();
        }
        
        return expression.accept(new GenericVisitorAdapter<DOMExpression, Object>() {
            @Override
            public DOMExpression visit(IntegerLiteralExpr n, Object arg) {
                return new IntLiteralDOMExpression(n.getValue());
            }
            
            @Override
            public DOMExpression visit(DoubleLiteralExpr n, Object arg) {
                return new DoubleLiteralDOMExpression(n.getValue());
            }

            @Override
            public DOMExpression visit(BinaryExpr n, Object arg) {
                if(!n.getOperator().equals(BinaryExpr.Operator.plus)) {
                    throw new RuntimeException("Only operator + is supported");
                }
                
                DOMExpression left = n.getLeft().accept(this, arg);
                DOMExpression right = n.getRight().accept(this, arg);
                return new OperatorAddDOMExpression(left, right);
            }                       
        }, null);
    }
}