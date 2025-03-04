package com.abn.scalar.dsa.day32;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.

If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.

Input 1:
A = [15, 11, 7, 19]
Input 2:
A = [2, 24, 22, 19]

Output 1:
[7, 19, 15, 11]
Output 2:
[2, 19, 24, 22]
 */
public class TenDigitSort {

    public int[] solve(int[] A) {

        Integer[] array = new Integer[A.length];
        for(int i = 0; i < A.length; i++) {
            array[i] = A[i];
        }

        Arrays.sort(array, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                if((a / 10) % 10 > (b / 10) % 10) {
                    return 1;
                } else if((a / 10) %10 < (b/10) % 10) {
                    return -1;
                } else {
                    if(a < b) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for(int i = 0; i < A.length; i++) {
            A[i] = array[i];
        }

        return A;
    }

    public static void main(String[] args) {

        TenDigitSort tenDigitSort = new TenDigitSort();
        System.out.println(Arrays.toString(tenDigitSort.solve(new int[] {15, 11, 7, 19})));
    }
}
