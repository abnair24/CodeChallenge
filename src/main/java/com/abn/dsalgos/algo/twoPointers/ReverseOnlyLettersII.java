package com.abn.dsalgos.algo.twoPointers;


/*
input : "Welc@me! To, Ooty#"
output : "cleW@me! oT, ytoO#"
 */
public class ReverseOnlyLettersII {

    public String reverseOnlyLetters(String str) {

        if(str == null || str.isEmpty()) {
            return str;
        }

        int start = 0;
        int end = 0;

        char[] characters = str.toCharArray();

        while(end < str.length()) {
            char endChar = characters[end];

            if(!Character.isLetterOrDigit(endChar) || endChar == ' ') {
                if(start == end && endChar == ' ') {
                    reverse(characters, start, end);
                } else {
                    reverse(characters, start, end-1);
                }
                start = end + 1;
            }
            end ++;
        }

        return new String(characters);
    }

    private void reverse(char[] chars, int start, int end) {
        if(start == end) {
            return ;
        }

        while(start < end) {
            char startChar = chars[start];
            char endChar = chars[end];
            chars[start] = endChar;
            chars[end] = startChar;

            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        ReverseOnlyLettersII reverseOnlyLettersII = new ReverseOnlyLettersII();
        System.out.println(reverseOnlyLettersII.reverseOnlyLetters("Welc@me! To, Ooty#"));
    }
}
