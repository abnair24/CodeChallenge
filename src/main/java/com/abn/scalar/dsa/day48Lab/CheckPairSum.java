package com.abn.scalar.dsa.day48Lab;

import java.util.Arrays;

/*
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.

Problem Constraints

1 <= Length of array B <= 105
0 <= Bi <= 109
0 <= A <= 109

Input Format

First argument A is the Target sum, and second argument is the array B

Output Format

Return an integer value 1 if there exists such pair, else return 0.

Example Input

Input 1:
A = 8
B = [3, 5, 1, 2, 1, 2]

Input 2:

A = 21
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]

Example Output

Output 1:
1
Output 2:

0
 */
public class CheckPairSum {

    public int solve(int A, int[] B) {

        int sptr = 0;
        int eptr = B.length - 1;
        int count = 0;

        Arrays.sort(B);

        int index = 0;
        while(sptr < eptr) {
            int sum = B[sptr] + B[eptr];
            if(sum == A) {
                return 1;
            }
            if(sum > A) {
                eptr --;
            } else {
                sptr ++;
            }
            index ++;
        }

        return count;
    }
}
