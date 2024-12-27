package com.abn.scalar.dsa.day27;

/*
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the
remaining array is maximum.

Find the maximum value of GCD.

Approach :
We can maintain two arrays for prefix and suffix gcd, like we do for prefix sum and suffix sum.
Then,for each index i from 1 to N, we can calculate gcd(prefix[i - 1], suffix[i + 1]).
This value will the gcd of the array when the i-th element of the array is removed.
We can return the maximum among all these values.
 */

public class GCDDeleteOne {

    public int solve(int[] array) {

        int[] suffixGcd = new int[array.length];
        int[] prefixGcd = new int[array.length];

        prefixGcd[0] = array[0];
        suffixGcd[array.length - 1] = array[array.length - 1];

        for(int i = 1; i < array.length; i ++) {
            prefixGcd[i] = gcd(array[i], prefixGcd[i - 1]);
        }

        for(int i = array.length - 2; i >= 0; i --) {
            suffixGcd[i] = gcd(array[i], suffixGcd[i + 1]);
        }

        int maxGcd = 0;

        for(int i = 0; i < array.length; i++) {

            if(i == 0) {
                maxGcd = Math.max(suffixGcd[i + 1], maxGcd);
            } else if(i == array.length - 1) {
                maxGcd = Math.max(prefixGcd[i - 1], maxGcd);
            } else {
                maxGcd = Math.max(gcd(prefixGcd[i - 1], suffixGcd[i + 1]), maxGcd);
            }
        }
        return maxGcd;
    }

    private int gcd(int num1, int num2) {

        if(num2 == 0) {
            return num1;
        }

        return gcd(num2, num1 % num2);
    }

    public static void main(String[] args) {
        GCDDeleteOne gcdDeleteOne = new GCDDeleteOne();
        System.out.println(gcdDeleteOne.solve(new int[] {12, 15, 18}));
    }
}
