package com.abn.dsalgos.challenges.stack;

import org.testng.Assert;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Input: s = "(()"
Output: 2

Input: s = ")()())"
Output: 4

Input: s = ""
Output: 0
 */

public class LongestValidParenthesis {

    public int longest(String str) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        int index = 0;

        while(index < str.length()) {

            if(str.charAt(index) == '(') {
                stack.push(index);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(index);
                } else {
                    max = Math.max(index - stack.peek(), max);
                }
            }
            index ++;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidParenthesis parenthesis = new LongestValidParenthesis();
        Assert.assertEquals(parenthesis.longest("))(((()))"), 6);
        Assert.assertEquals(parenthesis.longest("''"), 0);
        Assert.assertEquals(parenthesis.longest("())))(()"), 2);
    }
}
