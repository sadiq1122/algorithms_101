package com.example.algo101.ds.stack;

import java.util.Set;
import java.util.Stack;

public class InfixToPostfix {

    private final Stack<Character> stack = new Stack<>();

    private final Set<Character> operators = Set.of('^', '+', '-', '*', '/', '(', ')');


    // Get precedence of operators
    private int getPrecedence(Character operator) {
        return switch (operator) {
            case '^' -> 4;
            case '*', '/' -> 3;
            case '+', '-' -> 2;
            default -> -1;
        };
    }


    public String getPostFixExp(String infixExp) {
        StringBuilder result = new StringBuilder();
        stack.clear();
        for (int i = 0; i < infixExp.length(); i++) {
            char ch = infixExp.charAt(i);
            if (!operators.contains(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        //abcd^e-fgh*+^*+i-
        InfixToPostfix runner = new InfixToPostfix();
        System.out.println(runner.getPostFixExp(infix));
    }
}
