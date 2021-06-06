package com.abn.dsalgos.challenges.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleRow {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> rowNums = new ArrayList<>();

        int[][] cache = new int[rowIndex+1][rowIndex+1];
        cache[0][0] = 1;

        for(int j = 0; j <= rowIndex; j++) {
            rowNums.add(getPascal(rowIndex, j, cache));
        }
        return rowNums;
    }

    private int getPascal(int row, int col, int[][] cache) {

        if(row == col || col == 0) {
            cache[row][col] = 1;
        }

        if(cache[row][col] != 0) {
            return cache[row][col];
        } else {
            cache[row][col] = getPascal(row - 1, col - 1, cache) + getPascal(row - 1, col, cache);
        }

        return cache[row][col];
    }
}
