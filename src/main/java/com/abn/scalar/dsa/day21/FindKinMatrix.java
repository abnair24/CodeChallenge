package com.abn.scalar.dsa.day21;

/*

Given a matrix of integers A of size N x M and an integer B.

In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
If A[i][j] = B then return (i * 1009 + j)
If B is not present return -1.

Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
Note 3: Expected time complexity is linear
Note 4: Use 1-based indexing

A = [[1, 2, 3]
     [4, 5, 6]
     [7, 8, 9]]
B = 2

Output 1:-
1011

A = [[1, 2]
     [3, 3]]
B = 3

Output 2:-
2019
 */
public class FindKinMatrix {

    public int solve(int[][] matrix, int K) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols -1;
        int ans = Integer.MAX_VALUE;

        while(i < rows && j >= 0) {

            if(matrix[i][j] == K) {
                ans = Math.min(ans, (i+1)* 1009 +( j + 1));
                /*
                 instead of returning, again traverse to see multiple values of K are there ,
                 if so minimum index to return
                 */
                j--;
            } else if(matrix[i][j] < K) {
                i++;
            } else {
                j --;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        FindKinMatrix findKinMatrix = new FindKinMatrix();
        System.out.println(findKinMatrix.solve(new int[][] {
                {-5, -2, 1, 13},
                {-4, 0, 3, 14},
                {-3, 2, 6, 18}
        }, 20));

        System.out.println(findKinMatrix.solve(new int[][] {
                {2, 8, 8, 8},
                {2, 8, 8, 8},
                {2, 8, 8, 8}
        }, 8));
    }
}
