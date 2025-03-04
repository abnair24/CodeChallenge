package com.abn.scalar.dsa.day49;

import java.util.Arrays;

/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

A = [1, 2, 3, 4, 5]
 B = 5

 [2, 3]

  A = [5, 10, 20, 100, 105]
 B = 110

 [-1]
 */
public class SubarrayWithSum {

    public int[] solve(int[] array, int B) {
        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int size;
        int subSum = 0;
        int startIndex;
        int endIndex;

        for (int i = 0; i < array.length; i++) {
            subSum = subSum + array[i];

            while (subSum >= B) {
                size = i - start + 1;
                minSize = Math.min(size, minSize);
                if (subSum == B) {
                    startIndex = start;
                    endIndex = i;

                    int index = 0;
                    int[] result = new int[size];
                    for(int j = startIndex; j <= endIndex; j++) {
                        result[index ++] = array[j];
                    }
                    return result;
                }
                subSum = subSum - array[start];
                start++;
            }
        }

        return new int[] {-1};
    }

    public static void main(String[] args) {

        SubarrayWithSum subarrayWithSum = new SubarrayWithSum();
        System.out.println(Arrays.toString(subarrayWithSum.solve(new int[] { 1, 2, 3, 4, 5}, 5)));
    }
}
