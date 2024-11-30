package com.abn.learn.dsa.day21;

import java.util.Arrays;

/*
Print boundary elements
Given a Nx N matrix print boundary elements in clockwise direction
 */
public class BoundaryElementsInMatrixClockWise {

    public int[] solve(int[][] matrix, int N) {
        int i = 0;
        int j = 0;

        int[] result = new int[4 * (N-1)];

        int index = 0;

        for(int k = 1; k < N; k++) {
            result[index++] = matrix[i][j];
            j++;
        }

        for(int k = 1; k < N; k++) {
            result[index++] = matrix[i][j];
            i++;
        }

        for(int k = 1; k < N; k++) {
            result[index++] = matrix[i][j];
            j --;
        }

        for(int k = 1; k < N; k++) {
            result[index++] = matrix[i][j];
            i --;
        }

        return result;

    }

    public static void main(String[] args) {

        BoundaryElementsInMatrixClockWise boundaryElementsInMatrixClockWise = new BoundaryElementsInMatrixClockWise();
        System.out.println(Arrays.toString(boundaryElementsInMatrixClockWise.solve(new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        }, 5)));
    }
}
