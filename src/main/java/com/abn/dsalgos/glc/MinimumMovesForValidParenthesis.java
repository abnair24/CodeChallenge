package com.abn.dsalgos.glc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

 */
public class MinimumMovesForValidParenthesis {


    public String minimumMoves(String s) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    queue.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            if(!queue.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        MinimumMovesForValidParenthesis minimumMovesForValidParenthesis = new MinimumMovesForValidParenthesis();

        System.out.println(minimumMovesForValidParenthesis.minimumMoves("Lee(t(code))rs)"));
        System.out.println(minimumMovesForValidParenthesis.minimumMoves("))(("));
    }
}
