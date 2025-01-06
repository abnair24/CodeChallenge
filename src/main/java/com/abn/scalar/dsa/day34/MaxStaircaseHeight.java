package com.abn.scalar.dsa.day34;

/*
Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of
max-height using these blocks.

The first stair would require only one block, and the second stair would require two blocks, and so on.

Find and return the maximum height of the staircase.

Input 1:
 A = 10
Input 2:

 A = 20

Example Output

Output 1:
 4
Output 2:
 5
 */
public class MaxStaircaseHeight {
    public int solve(int A) {

        int rows = 0;
        int col = 1;
        while(A >= 0) {
            A = A - col;
            rows ++;
            col ++;
        }
        return rows - 1;
    }

    public static void main(String[] args) {
        MaxStaircaseHeight maxStaircaseHeight = new MaxStaircaseHeight();
        System.out.println(maxStaircaseHeight.solve(20));
        System.out.println(maxStaircaseHeight.solve(10));
    }
}
