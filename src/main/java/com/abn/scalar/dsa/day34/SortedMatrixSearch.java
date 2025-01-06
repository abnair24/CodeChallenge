package com.abn.scalar.dsa.day34;

/*
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.

Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output

Output 1:

1
Output 2:

0
 */
public class SortedMatrixSearch {

    public int solve(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;

        while(low <= high) {
            int mid = low + (high - low)/2 ;
            int row = mid / cols;
            int col = mid % cols;

            if(matrix[row][col] == target) {
                return 1;
            } else if(target > matrix[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {10, 11, 12, 13},
                {23, 24, 26, 27}
        };
        SortedMatrixSearch sortedMatrixSearch = new SortedMatrixSearch();
        System.out.println(sortedMatrixSearch.solve(matrix, 12));
        System.out.println(sortedMatrixSearch.solve(matrix, 28));
    }
}
