package com.abn.dsalgos.algo.dp;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

https://leetcode.com/problems/perfect-squares/
 */
public class MinPerfectSquaresSumToN {

    public int minimumSquares(int n) {

        int root = (int) Math.sqrt(n);

        int[] array = new int[root];

        if (n - (root * root) == 0) {
            return 1;
        } else {
            for (int i = 1; i <= root; i++) {
                array[i - 1] = i;
            }
        }

        Integer[][] cache = new Integer[array.length + 1][n + 1];
        int result = minimum(array, cache, 0, n);

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        return result;
    }

    private int minimum(int[] array, Integer[][] cache, int index, int target) {

        if (target == 0) {
            return 0;
        }

        if (index >= array.length || array.length == 0) {
            return Integer.MAX_VALUE;
        }

        if(cache[index][target] != null) {
            return cache[index][target];
        }

        int res;
        int count = Integer.MAX_VALUE;

        if ((array[index] * array[index]) <= target) {

            res = minimum(array, cache, index, target - (array[index] * array[index]));
            if (res != Integer.MAX_VALUE) {
                count = res + 1;
            }
        }

        int count1 = minimum(array, cache,index + 1, target);
        cache[index][target] = Math.min(count1, count);

        return cache[index][target];
    }

    public static void main(String[] args) {
        MinPerfectSquaresSumToN minPerfectSquaresSumToN = new MinPerfectSquaresSumToN();
        System.out.println(minPerfectSquaresSumToN.minimumSquares(13));
    }
}
