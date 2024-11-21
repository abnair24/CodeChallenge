package com.abn.learn.dsa.day9;

/*
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.

Input 1:
A = [1, 2, 3, 4, 5]
B = 4

Output 1:
6

Input 2:
A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65

Output 2:
36
 */

public class GoodSubarrays {

    public int solve(int[] array, int B) {

        int count = 0;
        int n = array.length;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j<n; j++) {
                sum+= array[j];

                int length = j - i + 1;

                if((length % 2==0 && sum < B) || (length % 2 != 0 & sum > B)) {
                    count ++;
                }
            }
        }

        return count;
    }
}
