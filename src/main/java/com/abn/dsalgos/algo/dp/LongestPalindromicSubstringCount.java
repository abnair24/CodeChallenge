package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given a string, find the length of its Longest Palindromic Substring (LPS).
In a palindromic string, elements read the same backward and forward.

Input: "abdbca"
Output: 3
Explanation: LPS is "bdb".


Input: = "cddpd"
Output: 3
Explanation: LPS is "dpd".

 */
public class LongestPalindromicSubstringCount {

    public int longestPalindrom(String s) {

        int[][] cache = new int[s.length()][s.length()];
        return palindromeHelper(0, s.length() - 1, s, cache);
    }

    private int palindromeHelper(int start, int end, String s, int[][] cache) {

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (cache[start][end] != 0) {
            return cache[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) {
            // if 2 char at both ends are equal, find the string inside those chars are palindrome.
            int subStrLen = end - start - 1;
            int count = palindromeHelper(start + 1, end - 1, s, cache);

            if (subStrLen == count) {
                return subStrLen + 2;
            }
        }

        int c1 = palindromeHelper(start + 1, end, s, cache);
        int c2 = palindromeHelper(start, end - 1, s, cache);

        cache[start][end] = Math.max(c1, c2);

        return cache[start][end];
    }

    public static void main(String[] args) {
        LongestPalindromicSubstringCount longestPalindromicSubstringCount = new LongestPalindromicSubstringCount();
        Assert.assertEquals(longestPalindromicSubstringCount.longestPalindrom("abdb"), 3);
    }
}
