package com.abn.dsalgos.algo.BFS;

/*
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
dead (represented by a 0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
  (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state

Input: board =
0 1 0           0 0 0
0 0 1      =>   1 0 1
1 1 1           0 1 1
0 0 0           0 1 0

Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 */
public class GameOfLife {

    int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] copyBoard = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixTraverse(i, j, rows, cols, board, copyBoard);
            }
        }
    }

    private void matrixTraverse(int i, int j, int m, int n, int[][] matrix, int[][] copyMatrix) {

        int count = 0;
        for (int[] dir : DIRECTIONS) {

            int x = dir[0] + i;
            int y = dir[1] + j;


            if (x > -1 && y > -1 && x < m && y < n) {
                if (copyMatrix[x][y] == 1) {
                    count++;
                }
            }
        }

        if (copyMatrix[i][j] == 1) {
            if (count < 2 || count > 3) {
                matrix[i][j] = 0;
            } else {
                matrix[i][j] = 1;
            }
        } else if (copyMatrix[i][j] == 0 && count == 3) {
            matrix[i][j] = 1;
        }

    }

    public static void main(String[] args) {
        int[][] input = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        GameOfLife game = new GameOfLife();
        game.gameOfLife(input);
    }
}
