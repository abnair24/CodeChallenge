package com.abn.dsalgos.challenges.stack;

import java.util.Stack;

/*
Given a string s containing only lowercase letters, continuously remove
adjacent characters that are the same and return the result.

s = "abccba", return ""
s = "foobar", return "fbar"
s = "abccbefggfe", return "a"

 */
public class RemoveAdjacentDuplicates {

    public String removeDuplicates(String s) {

        if (s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        int i = 1;
        stack.push(s.charAt(0));
        while (i < s.length()) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
            i++;
        }
        String st = "";

        while (!stack.isEmpty()) {
            st = String.valueOf(stack.pop()) + st;
        }
        return st;
    }
}
