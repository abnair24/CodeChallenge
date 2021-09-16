package com.abn.dsalgos.glc;

/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
 */
public class UglyNthNum {

    public int uglyNum(int n) {
        if( n == 0 || n == 1) {
            return n;
        }

        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;

        int[] result = new int[n];
        result[0] = 1;

        int i = 1, min =0;
        while ( i < n ) {
            min = Math.min(result[pointer2]*2,Math.min(result[pointer3]*3,result[pointer5]*5));

            if(min == result[pointer2]*2) {
                pointer2++;
            }
            if(min == result[pointer3]*3) {
                pointer3++;
            }
            if(min == result[pointer5]*5) {
                pointer5++;
            }
            result[i] = min;

            i++;

        }
        return result[n-1];
    }

    public static void main(String[] args) {

        UglyNthNum ugly = new UglyNthNum();
        ugly.uglyNum(1352);
    }
}
