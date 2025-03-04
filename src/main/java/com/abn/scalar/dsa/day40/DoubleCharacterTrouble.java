package com.abn.scalar.dsa.day40;

import java.util.Stack;

/*
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.

A = "abccbc"

"ac"

 A = "ab"
 "ab"
 */
public class DoubleCharacterTrouble {

    public String solve(String A) {

        if(A.length() == 0 || A.length() == 1) {
            return A;
        }
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        stack.push(A.charAt(0));

        for(int i = 1; i < A.length(); i++) {
            if(!stack.empty()) {
                if(stack.peek() == (A.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(A.charAt(i));
                }
            } else {
                stack.push(A.charAt(i));
            }
        }

        while(!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleCharacterTrouble doubleCharacterTrouble = new DoubleCharacterTrouble();
        System.out.println(doubleCharacterTrouble.solve("aaaaa"));
    }
}
