package com.abn.dsalgos.challenges.graph;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.


 */
public class WordSearch {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        boolean status = false;

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] isVisited = new boolean[rows][cols];

        int charIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(charIndex)) {
                    status = wordHelper(board, rows, cols, i, j, isVisited, charIndex, word);
                    if(status)  {
                        return true;
                    }
                }
            }
        }
        return status;
    }

    private boolean wordHelper(char[][] board, int m, int n, int i, int j, boolean[][] isVisited, int charIndex, String word) {

        if (charIndex >= word.length()-1) {
            return true;
        }

        charIndex = charIndex + 1;
        isVisited[i][j] = true;
        boolean status = false;

        for (int[] dir : DIRECTIONS) {

            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x > -1 && y > -1 && x < m && y < n && !isVisited[x][y] && board[x][y] == word.charAt(charIndex)) {
                status = wordHelper(board, m, n, x, y, isVisited, charIndex, word);
                if(status) {
                    return true;
                }
            }
        }
        isVisited[i][j] = false;
        return status;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
//        char[][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] input = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(wordSearch.exist(input, "AAB"));
    }
}
