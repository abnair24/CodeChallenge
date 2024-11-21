package com.abn.learn.dsa.day9;

/*
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.

Input 1:
 A = [2, 5, 6]
 B = 10

 Output 1:
 4

Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10

Output 2:
4

*/

public class CountingSubArraysLessThanSum {

    public int solve(int[] array, int B) {

        int n = array.length;
        int count = 0;
        int sum = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {

            sum+= array[i];

            while(sum >= B && start <= i) {
                sum = sum - array[start];
                start++;
            }

            count = count + (i - start + 1);
        }
        return count;
    }
}
