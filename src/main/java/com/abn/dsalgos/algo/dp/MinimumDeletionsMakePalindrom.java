package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given a string, find the minimum number of characters that we can remove to make it a palindrome.

I/P : abdbca
O/P: 1

I/P: cddpd
o/p: 2
 */

public class MinimumDeletionsMakePalindrom {

    //Minimum deletions is same as (Length of string - Longest palindromic subsequence).
    // in above, LPS for "abdbca" : abdba - 5.
    // Length of str = 6 : o/p => 6 -5 = 1

    public int minimumDeletions(String s) {

        int[][] cache = new int[s.length()][s.length()];

        int countLps = lpsHelper(s, 0, s.length() - 1, cache);

        return s.length() - countLps;
    }

    private int lpsHelper(String s, int start, int end, int[][] cache) {

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
            return 2 + lpsHelper(s, start + 1, end - 1, cache);
        }

        int count1 = lpsHelper(s, start + 1, end, cache);
        int count2 = lpsHelper(s, start, end - 1, cache);

        cache[start][end] = Math.max(count1, count2);
        return cache[start][end];
    }

    public static void main(String[] args) {
        MinimumDeletionsMakePalindrom minimumDeletionsMakePalindrom = new MinimumDeletionsMakePalindrom();
        Assert.assertEquals(minimumDeletionsMakePalindrom.minimumDeletions("cddpd"), 2);
        Assert.assertEquals(minimumDeletionsMakePalindrom.minimumDeletions("pqr"), 2);
        Assert.assertEquals(minimumDeletionsMakePalindrom.minimumDeletions("zzazz"), 0);
    }

}
