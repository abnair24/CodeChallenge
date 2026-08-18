package com.abn.dsalgos.algo.twoPointers;

/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

https://leetcode.com/problems/reverse-only-letters
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {

        if(s== null || s.isEmpty()) {
            return s;
        }

        int start = 0;
        int end = s.length() - 1;

        char[] characters = s.toCharArray();

        while(start < end) {
            char startChar = characters[start];
            char endChar = characters[end];

            if(!Character.isLetter(startChar)) {
                start ++;
            } else if(!Character.isLetter(endChar)) {
                end --;
            } else {
                characters[start] = endChar;
                characters[end] = startChar;
                start ++;
                end --;
            }
        }

       return new String(characters);
    }

    public static void main(String[] args) {

        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
