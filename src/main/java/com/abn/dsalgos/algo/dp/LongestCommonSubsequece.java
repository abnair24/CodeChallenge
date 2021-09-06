package com.abn.dsalgos.algo.dp;

/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some
 characters(can be none) deleted without changing the relative order of the remaining characters.
 (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a
 subsequence that is common to both strings.

If there is no common subsequence, return 0.

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

 */
public class LongestCommonSubsequece {

    public int LCS(String s1, String s2) {

        int[][] cache = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return lcsHelper(s1, s2, 0, 0, cache);
    }

    private int lcsHelper(String s1, String s2, int i, int j, int[][] cache) {

        int max = 0;
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            max = 1 + lcsHelper(s1, s2, i + 1, j + 1, cache);
        } else {
            max = Math.max(lcsHelper(s1, s2, i + 1, j, cache), lcsHelper(s1, s2, i, j + 1, cache));
        }
        cache[i][j] = max;
        return cache[i][j];
    }

    public static void main(String[] args) {

        LongestCommonSubsequece longestCommonSubsequece = new LongestCommonSubsequece();
        System.out.println(longestCommonSubsequece.LCS("stone", "longest"));
        System.out.println(longestCommonSubsequece.LCS("abdace", "babce"));
    }
}
