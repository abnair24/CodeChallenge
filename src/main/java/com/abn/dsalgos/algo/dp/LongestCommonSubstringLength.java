package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

public class LongestCommonSubstringLength {

    public int longestSubstring(String s1, String s2) {
        int[][] cache = new int[s1.length()][s2.length()];

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                cache[i][j] = -1;
            }
        }

        return lcsHelper(s1, s2, 0, 0, cache, 0);
    }

    private int lcsHelper(String s1, String s2, int i, int j, int[][] cache, int count) {

        if(i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if(cache[i][j] != -1) {
            return cache[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
          count = lcsHelper(s1, s2, i+1, j+1, cache, count +1);
        }

        int count1 = lcsHelper(s1, s2, i+1, j, cache, 0);
        int count2 = lcsHelper(s1, s2, i, j+1, cache, 0);

        cache[i][j] =  Math.max(count, Math.max(count1, count2));
        return cache[i][j];
    }

    public static void main(String[] args) {
        LongestCommonSubstringLength longestCommonSubstringLength = new LongestCommonSubstringLength();
        Assert.assertEquals(longestCommonSubstringLength.longestSubstring("abdca", "cbda"), 2);
    }
}
