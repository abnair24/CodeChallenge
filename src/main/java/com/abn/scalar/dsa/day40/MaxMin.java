package com.abn.scalar.dsa.day40;

/*
Given an array of integers A.


The value of an array is computed as the difference between the maximum element in the
array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 10^9+7.
 */
public class MaxMin {

    public int solve(int[] A) {

        int len = A.length;
        int mod = 1000000007;
        long sum = 0;

        for(int i = 0; i < len; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int j = i; j < len; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                sum = (sum + (max - min)) % mod;
            }
        }
        return (int)sum;
    }

    public static void main(String[] args) {

        MaxMin maxMin = new MaxMin();
        System.out.println(maxMin.solve(new int[] {4, 7, 3, 8}));
    }
}
