package com.abn.dsalgos.glc;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Input: s = "3[a2[c]]"
Output: "accaccacc"
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Map<Integer, Integer> bracketMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '[') {
                stack.push(i);
            } else if(ch == ']') {

                bracketMap.put(stack.pop(), i);
            }
        }

        String str = decodeHelper(s, bracketMap, 0, s.length() - 1);

        return str;
    }

    private String decodeHelper(String s, Map<Integer, Integer> map, int start, int end) {

        if(start == s.length()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i = start; i <= end; i ++) {

            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if(ch == '['){

                int endIndex = map.get(i);
                String str = decodeHelper(s, map, i + 1, endIndex - 1);

                for(int j = 0; j < num - 1; j++) {
                    sb.append(str);
                }

                num = 0;
            } else if(ch == ']') {
                continue;
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        System.out.println(decode.decodeString("3[a]2[bc]"));
        System.out.println(decode.decodeString("10[abcd]"));
    }
}
