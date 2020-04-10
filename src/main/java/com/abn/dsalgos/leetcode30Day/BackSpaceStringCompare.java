package com.abn.dsalgos.leetcode30Day;

import java.util.Stack;

public class BackSpaceStringCompare {

    public boolean isBackSpaceCompareSame(String first, String second) {
        return stringCompare(first).equals(stringCompare(second));
    }

    private String stringCompare(String str) {

        Stack<Character>stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c != '#') {
                stack.push(c);
            } else if(!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
