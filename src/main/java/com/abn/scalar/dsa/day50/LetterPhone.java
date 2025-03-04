package com.abn.scalar.dsa.day50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

 A = "012"
  ["01a", "01b", "01c"]
 */
public class LetterPhone {

    Map<Character, char[]> charMap = new HashMap<>();
    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return result;
        }

        LinkedList<Character> track = new LinkedList<>();
        charMap.put('0', new char[]{'0'});
        charMap.put('1', new char[]{'1'});
        charMap.put('2', new char[]{'a', 'b', 'c'});
        charMap.put('3', new char[]{'d', 'e', 'f'});
        charMap.put('4', new char[]{'g', 'h', 'i'});
        charMap.put('5', new char[]{'j', 'k', 'l'});
        charMap.put('6', new char[]{'m', 'n', 'o'});
        charMap.put('7', new char[]{'p', 'q', 'r', 's'});
        charMap.put('8', new char[]{'t', 'u', 'v'});
        charMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        backtrack(digits.toCharArray(), track, 0);
        return result;
    }

    private void backtrack(char[] digits, LinkedList<Character> track, int index) {

        if(track.size() == digits.length) {
            result.add(getString(track));
            return;
        }

        char digit = digits[index];
        for(char ch : charMap.get(digit)) {

            track.add(ch);
            backtrack(digits, track, index + 1);
            track.removeLast();
        }
    }

    private String getString(LinkedList<Character> track) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < track.size(); i++) {
            sb.append(track.get(i));
        }

        return sb.toString();
    }
}
