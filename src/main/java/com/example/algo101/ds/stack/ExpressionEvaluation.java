package com.example.algo101.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class ExpressionEvaluation {

    private static boolean isNumeric(String token) {
        try {
            Double.valueOf(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static Double evaluate(Double op1, Double op2, String op) {
        switch (op) {
            case "+": {
                return op1 + op2;
            }

            case "-": {
                return op2 - op1;
            }
            case "/": {
                return op2 / op1;
            }
            case "*": {
                return op1 * op2;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }
    }


    public static void main(String[] args) {
        String exp = "(2+4)*(4+6)";
        InfixToPostfix helper = new InfixToPostfix();
        String postfixExp = helper.getPostFixExp(exp);
        System.out.println(postfixExp);

        Stack<Double> stack = new Stack<>();

        String[] tokens = postfixExp.strip().split("\\s");
        System.out.println(Arrays.toString(tokens));

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.valueOf(token));
            } else {
                Double op1 = stack.pop();
                Double op2 = stack.pop();
                Double res = evaluate(op1, op2, token);
                stack.push(res);
            }
        }

        System.out.println("result -> " + stack.peek());

    }
}
