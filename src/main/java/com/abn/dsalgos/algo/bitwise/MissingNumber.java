package com.abn.dsalgos.algo.bitwise;

/*
Given an array of n-1 integers in the range from 1 to n, find the one number that is missing from the array.

steps to find the missing number using XOR:

    1. XOR all the numbers from 1 to n, let’s call it x1.
    2. XOR all the numbers in the input array, let’s call it x2.
    3. The missing number can be found by x1 XOR x2.
 */
public class MissingNumber {

    public int findNumber(int[] array) {

        int x1 = 1;

        // XOR all the numbers from 1 to n
        for (int i = 2; i < array.length; i++) {
            x1 = x1 ^ i;
        }

        int x2 = array[0];
        //XOR all the numbers in the input array
        for (int i = 1; i < array.length; i++) {
            x2 = x2 ^ array[i];
        }

        //The missing number can be found by x1 XOR x2
        return x1 ^ x2;
    }
}
