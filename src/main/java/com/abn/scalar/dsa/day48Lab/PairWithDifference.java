package com.abn.scalar.dsa.day48Lab;

import java.util.Arrays;

/*
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.


Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0
 */

public class PairWithDifference {

    public int solve(int[] A, int B) {

        Arrays.sort(A);

        int len = A.length;
        int startPtr = 0;
        int endPtr = startPtr + 1;
        int count = 0;

        while (endPtr < len) {
            int diff = Math.abs(A[endPtr] - A[startPtr]);

            if(diff > B) {
                startPtr ++;

            } else if(diff < B) {
                endPtr ++;
            } else {
                int current = A[endPtr];
                while(endPtr < len && A[endPtr] == current) {
                    endPtr ++;
                }

                current = A[startPtr];
                while(startPtr < endPtr && A[startPtr] == current) {
                    startPtr ++;
                }
                count ++;
            }

            if(startPtr == endPtr) {
                endPtr++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
