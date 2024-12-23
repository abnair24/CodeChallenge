package com.abn.scalar.dsa.day21;

import java.util.Arrays;

/*
Print boundary elements Given a NN matrix print boundary elements in clockwise direction.
 */
public class RobotMovement {

    public int[] solve(int[][] matrix, int N) {
        int index = 0;
        int[] result = new int[N * N];
        int i = 0;
        int j = 0;
        while (N > 1) {

            for (int k = 1; k < N; k++) {
                result[index++] = matrix[i][j];
                j++;
            }

            for (int k = 1; k < N; k++) {
                result[index++] = matrix[i][j];
                i++;
            }

            for (int k = 1; k < N; k++) {
                result[index++] = matrix[i][j];
                j--;
            }

            for (int k = 1; k < N; k++) {
                result[index++] = matrix[i][j];
                i--;
            }

            N = N-2;
            i++;
            j++;
        }

        if(N == 1) {
            result[index] = matrix[i][j];
        }
        return result;
    }

    public static void main(String[]    args) {
        RobotMovement robotMovement = new RobotMovement();
        System.out.println(Arrays.toString(robotMovement.solve(new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        }, 5)));
    }
}
