package com.abn.learn.dsa.day16;

/*
You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.

Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]

      -5
 */
public class MatrixAntiDiagonalSum {

    public int solve(final int[][] matrix) {

        int j = matrix.length - 1;
        int sum = 0;
        for(int i = 0; i < matrix.length; i ++) {
            sum = sum + matrix[i][j];
            j --;
        }

        return sum;
    }
}