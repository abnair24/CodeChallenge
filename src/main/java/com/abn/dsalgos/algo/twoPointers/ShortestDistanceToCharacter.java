package com.abn.dsalgos.algo.twoPointers;

import java.util.Arrays;

/*
Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length
and answer[i] is the distance from index i to the closest occurrence of character c in s.
The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

https://leetcode.com/problems/shortest-distance-to-a-character/


Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 */

public class ShortestDistanceToCharacter {

    public int[] shortestToChar(String s, char c) {

        int startPtr = 0;
        int charPtr = 0;
        int len = s.length() - 1;

        int[] array = new int[s.length()];

        // Filling array with MAX_VALUE to ensure that if character occurs only once, then remaining array when taken minimum
        // on iterating from right to left wont be defaulted to zero.
        // Eg: "aaba", 'b'
        Arrays.fill(array, Integer.MAX_VALUE);

        for(int i = 0; i <=len; i ++) {

            if(c == s.charAt(i)) {
                array[i] = 0;

                while(startPtr < charPtr) {
                    array[startPtr] = Math.abs(startPtr - charPtr);
                    startPtr++;
                }
                startPtr++;
            }
            charPtr++;
        }

        startPtr = len;
        charPtr = len;

        for(int i = len; i >=0 ; i--) {

            if(c == s.charAt(i)) {
                array[i] = 0;

                while(charPtr < startPtr) {
                    array[startPtr] = Math.min(array[startPtr], Math.abs(startPtr - charPtr));
                    startPtr --;
                }
                startPtr --;
            }
            charPtr --;
        }

        return array;

    }

    public static void main(String[] args) {

        ShortestDistanceToCharacter shortestDistanceToCharacter = new ShortestDistanceToCharacter();
        shortestDistanceToCharacter.shortestToChar("loveleetcode", 'e');
        shortestDistanceToCharacter.shortestToChar("aaaba", 'b');
    }
}
