package com.abn.dsalgos.leetcode30Day;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int num) {

        int i = 5;
        int zeroes = 0;

        while(num/i >= 1) {
            zeroes += num/i;
            i *= 5;
        }

        System.out.println(zeroes);
        return zeroes;
    }
}
