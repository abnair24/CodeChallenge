package com.abn.learn.dsa.day21;

import java.util.Arrays;

/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.


 */

public class SpiralOrderII {

    public int[][] generateMatrix(int A)
    {
        int[][] result = new int[A][A];
        int i = 0;
        int j = 0;
        int num = 1;

        while (A > 1) {

            for (int k = 1; k < A; k++) {
                result[i][j] = num++;
                j++;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = num;
                num++;
                i++;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = num;
                num++;
                j--;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = num;
                num++;
                i--;
            }

            A = A-2;
            i++;
            j++;
        }

        if(A == 1) {
            result[i][j] = num;
            num ++;
        }
        return result;
    }

    public static void main(String[] args) {

        SpiralOrderII spiralOrderII = new SpiralOrderII();
        System.out.println(Arrays.deepToString(spiralOrderII.generateMatrix(6)));
    }
}
