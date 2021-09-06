package com.abn.dsalgos.glc;

/*
Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25).
 Initially, your finger is at index 0. To type a character, you have to move your finger to the index of
  the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4

Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
Output: 73
 */
public class SpecialKeyboard {

    public int calculateTime(String keyboard, String word) {

        int time = 0;
        int pos = 0;

        for (int i = 0; i < word.length(); i++) {
            int index = keyboard.indexOf(word.charAt(i));
            time = time + Math.abs(index - pos);
            pos = index;
        }
        return time;
    }
}
