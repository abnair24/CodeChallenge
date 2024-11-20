package com.abn.learn.dsa.day16;

/*
Given 2D Matrix, print all elements diagonally right to left
(MXN)

{
{1, 2, 3, 4},
{5, 6, 7, 8},
{9, 10, 11, 12}
}

output : {1}, {2, 5}, {3, 6, 9}, {4, 7, 10}, {8, 11}, {12}

hint: diagonal starting index possibilities : 0th row  0 to N-1 col, then N-1 th col  0 to M-1 row
 */

public class MatrixAllDiagonalRightToLeft {


    public void solve(int[][] matrix) {

        int row = 0;
        for(int col = 0; col < matrix[0].length; col ++) {

            int sr = row;
            int sc = col;

            while(sr < matrix.length && sc >= 0) {
                System.out.print(matrix[sr][sc] + " ");
                sr++;
                sc--;
            }

            System.out.println();
        }

        int col = matrix[0].length - 1;
        for(row = 1; row < matrix.length; row++) {

            int sr = row;
            int sc = col;

            while(sr < matrix.length && sc >= 0) {
                System.out.print(matrix[sr][sc] + " ");
                sr ++;
                sc --;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MatrixAllDiagonalRightToLeft matrixAllDiagonalRightToLeft = new MatrixAllDiagonalRightToLeft();

        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        matrixAllDiagonalRightToLeft.solve(matrix);
    }
}