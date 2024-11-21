package com.abn.learn.dsa.day16;

/*
You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.

Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.

[3 3 1 -2 -3 -4 5 -6 -7 -8 9]

15

 */
public class MatrixDiagonalSum {

    public int solve(final int[][] A) {

        int rows = A.length;
        int sum = 0;
        for(int i = 0; i < rows; i++) {
            sum = sum+ A[i][i];
        }

        return sum;
    }
}