package com.abn.dsalgos.algo.twoPointers;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"

 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        char [] chars = s.toCharArray();

        int start = 0;
        int end = 0;

        while(end <= s.length()) {
            if(end == s.length() || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }

            end ++;
        }

        return new String(chars);
    }

    private void reverse(char[] chArray, int start, int end) {


        while(start < end) {
            char startChar = chArray[start];
            char endChar = chArray[end];
            chArray[start] = endChar;
            chArray[end] = startChar;

            start ++;
            end --;
        }

    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        System.out.println(reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"));
    }
}
