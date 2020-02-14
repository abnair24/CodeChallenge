package com.abn.dsalgos.algo;


/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

n = 5
n! = 120
Number of trailing zeros = 1
So, return 1

 */
public class FactorialTrailingZeros {

    public int trailingZeros(int input) throws Exception {
        return (input == 0) ? 0 : (input/5) + trailingZeros(input/5);
    }
}
