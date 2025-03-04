package com.abn.scalar.dsa.day31;

import com.abn.scalar.dsa.day52.SumOfNumbersLL;

import java.util.Arrays;

/*
You are given an array A of integers of length N and two indices, B and C.

Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.

A = [59, 11, 8, 91, 49, 44, 8]
B = 4
C = 6

Output:
[59, 11, 8, 91, 8, 44, 49]

A = [50, 40, 30, 20, 10]
B = 0
C = 3

[20, 30, 40, 50, 10]
 */
public class SortSubArray {

    public int[] solve(int[] A, int B, int C) {

        int[] input = new int[C-B +1];
        for(int i = B; i <= C; i++) {
            input[i-B] = A[i];
        }

        int[] result = mergeSort(input);

        for(int i = B; i <= C; i++) {
            A[i] = result[i - B];
        }
        return A;
    }

    public int[] mergeSort(int[] input) {

        if (input.length <= 1) {
            return input;
        }

        int mid = input.length /2;
        int len = input.length;

        int[] left = mergeSort(Arrays.copyOfRange(input, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(input, mid, len));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] < right[rightIndex]) {
                result[resultIndex ++] = left[leftIndex ++];
            } else {
                result[resultIndex ++] = right[rightIndex ++];
            }
        }

        while(leftIndex < left.length) {
            result[resultIndex ++] = left[leftIndex ++];
        }

        while(rightIndex < right.length) {
            result[resultIndex ++] = right[rightIndex ++];
        }
        return result;
    }

    public static void main(String[] args) {

        SortSubArray sortSubArray = new SortSubArray();
        System.out.println(Arrays.toString(sortSubArray.solve(new int[] {59, 11, 8, 91, 49, 44, 8}, 4, 6)));
    }
}
