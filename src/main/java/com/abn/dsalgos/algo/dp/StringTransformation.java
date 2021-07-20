package com.abn.dsalgos.algo.dp;

import org.jsoup.Jsoup;

/*
Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
Write a function to calculate the count of the minimum number of deletion and insertion operations.



 */
public class StringTransformation {

    public int[] transformation(String s1, String s2) {

        int[][] cache = new int[s1.length()][s2.length()];

        for(int i = 0; i< s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        int count = transformationHelper(s1, s2, 0, 0, cache);
        int[] result = new int[2];

        //To transform s1 into s2, we need to delete everything from s1 which is not part of LCS,
        // so minimum deletions we need to perform from s1 => s1.length - count

        //insert everything in s1 which is present in s2 but not part of LCS,
        // so minimum insertions we need to perform in s1 => s2.length - count;
        result[0] = s1.length() - count;
        result[1] = s2.length() - count;

        return result;
    }

    private int transformationHelper(String s1, String s2, int i, int j, int[][] cache) {

        int max = 0;

        if(i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if(cache[i][j] != -1) {
            return cache[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            max = 1 + transformationHelper(s1, s2, i+1, j+1, cache);
        } else {
            max = Math.max(transformationHelper(s1, s2, i + 1, j, cache), transformationHelper(s1, s2, i, j + 1, cache));
        }

        cache[i][j] = max;

        return cache[i][j];
    }
}
