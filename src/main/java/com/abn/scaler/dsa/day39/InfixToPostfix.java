package com.abn.scaler.dsa.day39;

import java.util.Stack;

/*
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.


String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


A = "x^y/(a*z)+b"
o/p:

 A = "a+b*(c^d-e)^(f+g*h)-i"
 o/p: "abcd^e-fgh*+^*+i-"

 */

public class InfixToPostfix {

    public String solve(String A) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private int precedence(char val) {
        switch (val) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println(infixToPostfix.solve("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPostfix.solve("x^y/(a*z)+b"));
    }
}
