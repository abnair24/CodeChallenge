package com.abn.scalar.dsa.day09;

/*
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise

Input 1:


A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6


Example Output

Output 1:
1
Output 2:

0
 */

public class SubarraysWithGivenSumLength {

    public int solve(int[] array, int b, int c) {

        int n = array.length;
        int currentSum = 0;

        if(n < b) {
            return 0;
        }

        for(int i = 0; i < b; i++) {
            currentSum += array[i];
        }

        if(currentSum == c) {
            return 1;
        }

        for(int i = b; i < n; i++) {
            currentSum = currentSum - array[i-b] +array[i];

            if(currentSum == c) {
                return 1;
            }
        }
        return 0;
    }
}
