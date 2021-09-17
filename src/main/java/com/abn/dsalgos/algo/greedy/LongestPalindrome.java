package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of
the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Input: s = "a"
Output: 1

Input: s = "bb"
Output: 2

 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s.length() == 1) {
            return 1;
        }
        boolean oddStatus = false;
        int evenCount = 0;
        int oddCount = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            freqMap.put(curr, freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {

            if (entry.getValue() % 2 == 0) {
                evenCount = evenCount + entry.getValue();
            } else {
                oddStatus = true;
                oddCount = oddCount + entry.getValue() - 1;
            }
        }

        return oddStatus == true ? evenCount + oddCount + 1 : evenCount;
    }

    public static void main(String[] args) {
        Assert.assertEquals(new LongestPalindrome().longestPalindrome("abccccdd"), 7);
    }
}
