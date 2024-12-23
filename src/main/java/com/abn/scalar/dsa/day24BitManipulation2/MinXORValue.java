package com.abn.scalar.dsa.day24BitManipulation2;

import java.util.Arrays;

/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

 A = [0, 2, 5, 7]

 2

  A = [0, 4, 7, 9]

  3

  Approach : Sort array, xor adj elements , i & i+1
 */
public class MinXORValue {

    public int solve(int[] array) {

        Arrays.sort(array);
        int result = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length - 1; i++) {
            result = array[i] ^ array[i+1];
            min = Math.min(result, min);
        }
        return min;
    }

    public static void main(String[] args) {

        MinXORValue minXORValue = new MinXORValue();
        System.out.println(minXORValue.solve(new int[] {4, 0, 9, 7}));
        System.out.println(minXORValue.solve(new int[] {2, 0, 7, 5}));

    }
}
