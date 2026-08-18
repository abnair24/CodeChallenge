package com.abn.dsalgos.problems;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

 */
public class UniqueCharacterInString {

    public int firstUniqChar(String s) {

        int[] charcount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charcount[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (charcount[index] == 1) {
                return i;
            }
        }
        return -1;
    }
}
