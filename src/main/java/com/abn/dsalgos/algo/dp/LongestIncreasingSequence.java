package com.abn.dsalgos.algo.dp;

/*
Given a number sequence, find the length of its Longest Increasing Subsequence (LIS).
In an increasing subsequence, all the elements are in increasing order (from lowest to highest).

Input: {4,2,3,6,10,1,12}
Output: 5
Explanation: The LIS is {2,3,6,10,12}.

Input: {-4,10,3,7,15}
Output: 4
Explanation: The LIS is {-4,3,7,15}.
 */
public class LongestIncreasingSequence {

    public int longest(int[] array) {
        int[][] cache = new int[array.length][array.length + 1];
        return longestrec(array, 0, -1, cache);
    }

    private int longestrec(int[] array, int index, int previous, int[][] cache) {

        if (index >= array.length) {
            return 0;
        }

        if (cache[index][previous + 1] != 0) {
            return cache[index][previous + 1];
        }

        int count1 = 0;
        if (previous == -1 || array[index] > array[previous]) {
            count1 = 1 + longestrec(array, index + 1, index, cache);
        }
        int count2 = longestrec(array, index + 1, previous, cache);

        cache[index][previous + 1] = Math.max(count1, count2);

        return cache[index][previous + 1];
    }

    public static void main(String[] args) {

        LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
        System.out.println(longestIncreasingSequence.longest(new int[] {4, 2, 3, 6, 10, 1, 12}));
        System.out.println(longestIncreasingSequence.longest(new int[] {-4, 3, 7, 15}));
    }
}
