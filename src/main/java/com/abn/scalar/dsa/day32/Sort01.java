package com.abn.scalar.dsa.day32;

import java.util.Arrays;

/*
Given an array A of 0s and 1s of length N. Sort this array.

Note - Do not use any sorting algorithm or library's sort method.

Input 1:

A = [0,0,1,0,1,1,0]
Input 2:

A = [1,0]


Example Output

Output 1:

[0,0,0,0,1,1,1]
Output 2:

[0,1]
 */
public class Sort01 {

    public int[] solve(int[] A) {

        int startPtr = 0;
        int endPtr = A.length - 1;

        while(startPtr < endPtr) {
            if(A[startPtr] == 0) {
                startPtr ++;
            }
            if(A[endPtr] == 1) {
                endPtr --;
            }

            if(startPtr < endPtr && (A[startPtr] == 1 && A[endPtr] == 0)) {
                int temp = A[startPtr];
                A[startPtr] = A[endPtr];
                A[endPtr] = temp;

            }
        }

        return A;
    }

    public static void main(String[] args) {

        Sort01 sort01 = new Sort01();
        System.out.println(Arrays.toString(sort01.solve(new int[] {0, 0, 1, 0, 1, 1, 0})));
        System.out.println(Arrays.toString(sort01.solve(new int[] {0,0,1,0,1,0,1})));
    }
 }
