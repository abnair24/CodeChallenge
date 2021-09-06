package com.abn.dsalgos.challenges.stack;

import java.util.Stack;

/*
 Given two strings s and t, which represents a sequence of keystrokes, where # denotes a backspace,
 return whether or not the sequences produce the same result.

 s = "ABC#", t = "CD##AB", return true
s = "como#pur#ter", t = "computer", return true
s = "cof#dim#ng", t = "code", return false
 */
public class BackSpaceStringCompare {

    public boolean isBackSpaceCompareSame(String first, String second) {

        return stringCompare(first).equals(stringCompare(second));
    }

    private String stringCompare(String str) {

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
