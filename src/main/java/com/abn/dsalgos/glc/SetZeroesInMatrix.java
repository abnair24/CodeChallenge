package com.abn.dsalgos.glc;

/*
Given a 2D matrix, if any cell contains 0, set 0 to that whole row and column.
So if cell (i, j) contains 0, then set ith row and jth column to 0.

Input:  1 1 1 1
        1 0 1 1
        0 1 1 0

Output: 0 0 1 0
        0 0 0 0
        0 0 0 0

 */
public class SetZeroesInMatrix {

    public static void main(String[] args) {
        int[][] input = {{1, 1, 1, 1}, {1, 0, 1, 1}, {0, 1, 1, 0}};
        SetZeroesInMatrix setZeroesInMatrix = new SetZeroesInMatrix();
        setZeroesInMatrix.setZero(input);
    }

    public int[][] setZero(int[][] array) {

        int rows = array.length;
        int cols = array[0].length;

        boolean isVisited[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0 && !isVisited[i][j]) {
                    setRowCol(i, j, rows, cols, array, isVisited);
                }
            }
        }

        return array;
    }

    private void setRowCol(int row, int col, int rows, int cols, int[][] arr, boolean[][] isVisited) {

        for (int i = 0; i < rows; i++) {
            if (arr[i][col] != 0) {
                arr[i][col] = 0;
                isVisited[i][col] = true;
            }

        }

        for (int j = 0; j < cols; j++) {
            if (arr[row][j] != 0) {
                arr[row][j] = 0;
                isVisited[row][j] = true;
            }
        }
    }
}
