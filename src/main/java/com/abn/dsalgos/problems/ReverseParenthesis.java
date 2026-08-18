package com.abn.dsalgos.problems;

import java.util.Stack;

public class ReverseParenthesis {

    public String reverseParentheses(String str) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if(stack.peek() == '(') {
                    stack.pop();
                }

                if (!stack.isEmpty() ) {
                    pushToStack(sb.toString(), stack);
                    sb.setLength(0);
                }
            }
        }
        return sb.toString();
    }

    private void pushToStack(String s, Stack<Character> stack) {
        if (!s.isEmpty()) {
            for (char ch : s.toCharArray()) {
                stack.push(ch);
            }
        }
    }

    public static void main(String[] args) {

        ReverseParenthesis testFile = new ReverseParenthesis();
        System.out.println(testFile.reverseParentheses("(u(love)i)"));
    }
}
