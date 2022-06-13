package com.abn.dsalgos.glc;

import org.omg.CORBA.UserException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/*

Case 1: Add char to stack if its empty
Case 2: Stack peek() > char, then remove from stack top if its repeating again and then insert char
Case 3: Stack peek() < char, add char.
 */
public class RemoveDuplicateChar {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i ++) {

            map.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!set.contains(ch)) {
                while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) > i) {
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
                set.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {

            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveDuplicateChar removeDuplicateChar = new RemoveDuplicateChar();
        removeDuplicateChar.removeDuplicateLetters("bcabc");
    }
}
