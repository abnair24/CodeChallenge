package com.abn.scalar.dsa.day04;

/*
You are given an integer A. You have to tell whether its perfect or not. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

input = 4. Output = 0 (1+2 != 4)
input = 6. Output = 1 (1+ 2 + 3 = 6) (excluding number)
 */

public class PerfectNumber {

    public int solve(int A) {

        int sum = 0;

        for(int i = 1; i < A; i++) {
            if( A % i == 0) {
                sum = sum + i;
            }
        }

        if(sum == A) {
            return 1;
        } else {
            return 0;
        }
    }
}
