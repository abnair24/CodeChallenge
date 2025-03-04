package com.abn.scalar.dsa.day48Lab;

import java.util.Arrays;

public class PascalsTriangle {

    public int[][] solve(int row) {

        int[][] result = new int[row][row];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(Arrays.deepToString(pascalsTriangle.solve(5)));
    }
}
