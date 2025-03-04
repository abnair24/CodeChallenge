package com.abn.scalar.dsa.day39;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {

    public boolean solve(String str) {

        Map<Character, Character> openingToClosingBrackets = new HashMap<>();
        openingToClosingBrackets.put(']', '[');
        openingToClosingBrackets.put('}', '{');
        openingToClosingBrackets.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(openingToClosingBrackets.containsValue(ch)) {
                stack.push(ch);
            } else if(stack.empty() || stack.pop() != openingToClosingBrackets.get(ch)) {
               return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
        System.out.println(balancedParenthesis.solve("(*))"));
    }
}
