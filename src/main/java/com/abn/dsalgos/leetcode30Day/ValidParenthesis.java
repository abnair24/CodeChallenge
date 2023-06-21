package com.abn.dsalgos.leetcode30Day;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> openingToClosingBrackets = new HashMap<>();
        openingToClosingBrackets.put(']', '[');
        openingToClosingBrackets.put('}', '{');
        openingToClosingBrackets.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (openingToClosingBrackets.containsValue(charAt) || openingToClosingBrackets.containsKey(charAt)) {
                if (openingToClosingBrackets.containsValue(charAt)) {
                    stack.push(charAt);
                } else if (stack.isEmpty() || stack.pop() != openingToClosingBrackets.get(charAt)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
