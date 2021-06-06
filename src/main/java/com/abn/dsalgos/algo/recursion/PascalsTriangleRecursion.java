package com.abn.dsalgos.algo.recursion;

import com.google.common.collect.Lists;

import java.util.List;

/*
Recursive solution for pascal's triangle (NON - DP)

Pascal' triangle for 5 rows

                1              ----> row : 1
             1     1           ----> row : 2
           1    2     1        ----> row : 3
         1   3     3    1      ----> row : 4
       1   4    6    4    1    ----> row : 5
 */
public class PascalsTriangleRecursion {

    public List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> triangle = Lists.newArrayList();

        for (int i = 1; i <= rows; i++) {
            List<Integer> rowNums = Lists.newArrayList();
            for (int j = 1; j <= i; j++) {
                rowNums.add(getPascal(i, j));
            }
            triangle.add(rowNums);
        }
        return triangle;
    }

    private int getPascal(int row, int col) {

        //base case
        if (row == col || col == 1) {
            return 1;
        } else {
            //recursive
            return getPascal(row - 1, col - 1) + getPascal(row - 1, col);
        }
    }
}
