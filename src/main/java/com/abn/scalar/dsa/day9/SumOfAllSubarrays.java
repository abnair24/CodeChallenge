package com.abn.scalar.dsa.day9;

/*
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting
zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.

Example Input

Input 1:
A = [1, 2, 3]
Input 2:

A = [2, 1, 3]


Example Output

Output 1:
20
Output 2:

19
 */

public class SumOfAllSubarrays {

    public long subarraySum(int[] array) {

        long ans = 0;
        int n = array.length;
        for(int i = 0; i < n; i++) {

            ans = ans +  (long) (i + 1) * (n - i) * array[i];
        }
        return ans;
    }
}
