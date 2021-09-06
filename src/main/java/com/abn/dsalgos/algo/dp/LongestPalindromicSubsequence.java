package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given a sequence, find the length of its Longest Palindromic Subsequence (LPS).
In a palindromic subsequence, elements read the same backward and forward.
 */
public class LongestPalindromicSubsequence {

    public int subsequence(String s) {

        int[][] cache = new int[s.length()][s.length()];
        return subsequenceHelper(s, 0, s.length() - 1, cache);
    }

    private int subsequenceHelper(String s, int start, int end, int[][] cache) {
        int count = 0;


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
            return subsequenceHelper(s, start + 1, end - 1, cache) + 2;
        }

        int count1 = subsequenceHelper(s, start + 1, end, cache);
        int count2 = subsequenceHelper(s, start, end - 1, cache);

        cache[start][end] = Math.max(count1, count2);
        return cache[start][end];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        Assert.assertEquals(longestPalindromicSubsequence.subsequence("abdbca"), 5);
        Assert.assertEquals(longestPalindromicSubsequence.subsequence("cbbd"), 2);
        Assert.assertEquals(longestPalindromicSubsequence.subsequence("bbbab"), 4);
    }
}
