package com.abn.scalar.dsa.day47;


/*

Given an integer A, find and return the total number of digit 1 appearing in all non-negative
integers less than or equal to A.

 A = 10

 Output 1:

 2

Input 2:

 A = 11
 Output 2:
 4
 */
public class NumberOfDigitOne {

    public int solve(int A) {
        int count = 0;

        // Going through each digit position (ones, tens, hundreds, etc.)
        for (long i = 1; i <= A; i *= 10) {
            // Calculate the contribution of the current digit position
            long divider = i * 10;
            count += (A / divider) * i;

            // Calculate the partial cycle contribution
            long remainder = A % divider;
            count += Math.min(Math.max(remainder - i + 1, 0), i); // Count of 1's in partial cycle
        }

        return count;
    }
}
