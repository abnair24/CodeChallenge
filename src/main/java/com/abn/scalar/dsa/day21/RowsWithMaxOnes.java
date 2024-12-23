package com.abn.scalar.dsa.day21;

/*
Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

NOTE:

If two rows have the maximum number of 1 then return the row which has a lower index.
Rows are numbered from top to bottom and columns are numbered from left to right.
Assume 0-based indexing.
Assume each row to be sorted by values.
Expected time complexity is O(rows + columns).

Input 1:

 A = [   [0, 1, 1]
         [0, 0, 1]
         [0, 1, 1]   ]
Input 2:

 A = [   [0, 0, 0, 0]
         [0, 0, 0, 1]
         [0, 0, 1, 1]
         [0, 1, 1, 1]    ]

Output 1:
0

Output 2:
3

 */
public class RowsWithMaxOnes {

    public int solve(int[][]matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols -1;
        int ans = 0;

        while(i < rows && j >= 0) {

            if(matrix[i][j] == 1) {
                j--;
                ans = i;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        RowsWithMaxOnes rowsWithMaxOnes = new RowsWithMaxOnes();
        System.out.println(rowsWithMaxOnes.solve(new int[][] {
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 1}
        }));

        System.out.println(rowsWithMaxOnes.solve(new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        }));
    }
}
