package org.example.wordmath;

public class WordMath {
    public int calculate(String input) {
        Expression expression = new Expression(input);
        System.out.println("Expression: " + expression);
        return expression.evaluate();
    }
}
