package com.abn.dsalgos.algo.dp;

import java.util.ArrayList;
import java.util.List;

/*
Pascal triangle using recursion and memoization.

 */

public class PascalsTriangleMemoization {

    private int count = 0;

    public static void main(String[] args) {
        PascalsTriangleMemoization pascalsTriangleMemoization = new PascalsTriangleMemoization();
        pascalsTriangleMemoization.generatePascalTriangle(5);
    }

    public List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> triangle = new ArrayList<>();

        int[][] cache = new int[rows][rows];
        cache[0][0] = 1;

        List<Integer> rowNums = new ArrayList<>();
        rowNums.add(cache[0][0]);
        triangle.add(rowNums);

        for (int i = 1; i < rows; i++) {
            rowNums = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                rowNums.add(getPascal(i, j, cache));
            }
            triangle.add(rowNums);
        }
        return triangle;
    }

    private int getPascal(int row, int col, int[][] cache) {

        if (row == col || col == 0) {
            cache[row][col] = 1;
        }

        if (cache[row][col] != 0) {
            return cache[row][col];
        } else {
            cache[row][col] = getPascal(row - 1, col - 1, cache) + getPascal(row - 1, col, cache);
        }

        return cache[row][col];
    }
}
