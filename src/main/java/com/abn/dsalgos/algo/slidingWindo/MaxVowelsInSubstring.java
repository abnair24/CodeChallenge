package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;

/*
Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are (a, e, i, o, u).
 */

public class MaxVowelsInSubstring {

    public int maxVowels(String str, int k) {
        String vowel = "aeiou";
        int maxSize = 0;
        int size = 0;
        int start = 0;

        if(str == vowel){
            return k;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);

            //returns string representation of char argument
            // Note: Expensive operation compared char comparison for vowels.
            if (vowel.contains(String.valueOf(str.charAt(i)))) {
                size++;
            }

            int len = i - start + 1;
            if (len == k) {
                maxSize = Math.max(size, maxSize);

                if (vowel.contains(String.valueOf(str.charAt(start)))) {
                    size--;
                }
                hm.put(str.charAt(start), hm.get(str.charAt(start)) - 1);

                if (hm.get(str.charAt(start)) == 0) {
                    hm.remove(str.charAt(start));
                }
                start++;
            }
        }
        return maxSize;
    }
}
