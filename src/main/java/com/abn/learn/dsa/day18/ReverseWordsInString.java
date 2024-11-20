package com.abn.learn.dsa.day18;

/*
Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters.
The words in "s" are separated by at least one
space.

A = "the sky is blue"
Output : "blue is sky the"
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {

        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = str.length - 1; i >= 0; i--) {
            if(!str[i].isEmpty()) {
                sb.append(str[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {

        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("the sky is blue"));
    }
}