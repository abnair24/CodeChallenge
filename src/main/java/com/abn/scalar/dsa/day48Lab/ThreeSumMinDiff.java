package com.abn.scalar.dsa.day48Lab;

import java.util.Arrays;

/*
Given an array A of N integers, find three integers in A such that the sum is closest to
 a given number B. Return the sum of those three integers.

Assume that there will only be one solution.

Input 1:

A = [-1, 2, 1, -4]
B = 1

2

A = [1, 2, 3]
B = 6

6
 */
public class ThreeSumMinDiff {

    int minDiff = Integer.MAX_VALUE;
    int maxSum = Integer.MAX_VALUE;

    public static void main(String[] args) {

        ThreeSumMinDiff threeSumMinDiff = new ThreeSumMinDiff();
        int[] array = {-1, 2, 1, -4};
        System.out.println(threeSumMinDiff.solve(array, 1));
        int[] array1 = {1, 2, 3};
        System.out.println(threeSumMinDiff.solve(array1, 6));

        int[] array2 = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};
        System.out.println(threeSumMinDiff.solve(array2, -1));

        int[] array3 = {5, -2, -1, -10, 10};
        System.out.println(threeSumMinDiff.solve(array3, 5));
    }

    private int solve(int[] array, int target) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {

            int start = i + 1;
            int end = array.length - 1;

            while (start < end) {
                int diff = Math.abs(target - (array[i] + array[start] + array[end]));
                int sum = array[i] + array[start] + array[end];

                if (diff <= minDiff) {
                    minDiff = diff;
                    maxSum = sum;
                }

                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return maxSum;
    }
}
