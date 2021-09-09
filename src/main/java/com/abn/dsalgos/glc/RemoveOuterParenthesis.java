package com.abn.dsalgos.glc;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"

Input: s = "()()"
Output: ""
Explanation:
 */
public class RemoveOuterParenthesis {

    public String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        List<String> list = new LinkedList<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                if(stack.isEmpty()) {
                    start = i;
                }
                stack.push(s.charAt(i));
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    list.add(s.substring(start, i+1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String input : list) {
            sb.append(input, 1, input.length()-1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "(()())(())";

        RemoveOuterParenthesis parenthesis = new RemoveOuterParenthesis();
        System.out.println(parenthesis.removeOuterParentheses(s));
    }
}
