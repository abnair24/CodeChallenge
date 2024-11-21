package com.abn.learn.dsa.day7;

/*
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

A = [1, 2, 3, 4, 5]
B = [[0, 3], [1, 2]]

o/p: [10, 5]

A = [2, 2, 2]
B = [[0, 0], [1, 2]]

o/p: [2, 4]
 */

import java.util.Arrays;

public class PrefixRangeSum {

    public long[] rangeSum(int[] A, int[][] B) {

        long[] prefix = new long[A.length];
        long[] result = new long[B.length];

        prefix[0] = A[0];

        for(int i = 1; i < A.length; i++) {

            prefix[i] = prefix[i-1] + A[i];
        }

        for(int i = 0; i < B.length; i ++) {

            int left = B[i][0];
            int right = B[i][1];

            if(left == 0) {
                result[i] = (long) prefix[right];
            } else {
                result[i] = prefix[right] - prefix[left - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PrefixRangeSum prefixRangeSum = new PrefixRangeSum();
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[][] range = {{0, 3}, {1, 2}};


        long[] res = prefixRangeSum.rangeSum(array, range);
        Arrays.stream(res).forEach(System.out::println);
    }
}

