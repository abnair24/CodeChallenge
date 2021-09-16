package com.abn.dsalgos.glc;

import java.util.Stack;

/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing
two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
Input: s = "abbaca"
Output: "ca"

Input: s = "azxxzy"
Output: "ay"

 */

public class AdjacentDuplicatesRemoval {

    public String removeDuplicates(String s) {


        if(s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        int i = 0;

        while(i < s.length()) {
            if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty()) {
            return "";
        }

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new AdjacentDuplicatesRemoval().removeDuplicates("abbaca"));
    }
}
