package com.example.algo101.ds.stack;

import java.util.Stack;

public class InfixToPostfix {

    private Stack<Character> stack = new Stack<>();
    private StringBuilder result = new StringBuilder();


    private int getPrecedence(Character operator) {
        if (operator == '^') return 4;
        else if (operator == '/' || operator == '*') return 3;
        else if (operator == '+' || operator == '-') return 2;
        else return -1;
    }

    private boolean isOperator(Character token) {
        if (token == '^' || token == '*' || token == '/' || token == '+' || token == '-' || token == '(' || token == ')')
            return true;
        return false;
    }


    public String getPostFixExp(String infixExp) {
        result = new StringBuilder();
        for (int i = 0; i < infixExp.length(); i++) {
            char ch = infixExp.charAt(i);
            if (!isOperator(ch)) {
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
