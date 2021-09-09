package com.abn.dsalgos.glc;

/*
You are given a string text of words that are placed among some number of spaces.
Each word consists of one or more lowercase English letters and are separated by at least one space.
It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words
and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end,
meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.

Input: text = "hello   world"
Output: "hello   world"

Input: text = "  walks  udp package   into  bar a"
Output: "walks  udp  package  into  bar  a "

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
 */
public class RearrangeSpace {

    public String reorderSpaces(String text) {

        if(text.length() == 1 || text.length() == 0) {
            return text;
        }

        int count = 0;
        String result = "";

        for(int i = 0; i < text.length(); i ++) {
            if(Character.isWhitespace(text.charAt(i))) {
                count ++;
            }
        }

        String[] sp = text.trim().split("\\s+");
        int len = sp.length;

        if(len == 1) {
            StringBuilder space = new StringBuilder();

            if(sp[0].length() != text.length()) {
                for(int i = 0; i < text.length() - sp[0].length(); i ++) {
                    space.append(" ");
                }
                result = sp[0] + space.toString();
            } else {
                result = sp[0];
            }
            return result;
        }

        int spaceNeeded = count / (len - 1);

        StringBuilder spaceSb = new StringBuilder();
        for(int i = 0; i < spaceNeeded; i ++) {
            spaceSb.append(" ");
        }

        String spaceString = spaceSb.toString();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i ++) {
            sb.append(sp[i]);
            if(i != len - 1) {
                sb.append(spaceString);
            }
        }

        int diff = text.length() - sb.length();
        if(diff > 0) {
            for(int i = 0; i < diff; i ++)
                sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeSpace rearrangeSpace = new RearrangeSpace();
        rearrangeSpace.reorderSpaces("a");
    }
}
