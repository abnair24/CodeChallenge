package com.abn.scalar.dsa.day13;

/*
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression,
otherwise return 0.

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements
is the same.

i/p:  A = [3, 5, 1]
o/p: 1

i/p:  A = [2, 4, 1]
o/p: 0

 */

import java.util.Arrays;

public class ArithmeticProgression {
    public int solve(int[] array) {

        if(array.length == 0 || array.length == 1) {
            return 0;
        }

        Arrays.sort(array);
        int diff = 0;
        int currentDiff = 0;

        for(int i = 1; i < array.length; i++) {

            diff = Math.abs(array[i] - array[i-1]);
            if(i == 1) {
                currentDiff = diff;
            }

            if(diff != currentDiff) {
                return 0;
            }
        }

        return 1;
    }
}
