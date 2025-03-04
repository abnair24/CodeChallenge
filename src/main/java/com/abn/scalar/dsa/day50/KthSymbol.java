package com.abn.scalar.dsa.day50;



/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each
occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 A = 3
 B = 0

 Row 1: 0
 Row 2: 01
 Row 3: 0110

=============Approach================

Row
1       0                 0
2       01                0 1
3       01 10             0 1 1 0
4       0110 1001         0 1 1 0 1 0 0 1
5       01101001 10010110

in Row 4 -->
0 1 1 0 1 0 0 1   len = 8 = 2^3  mid = 4
here first 4 bits{ 0 to 3 } are 0 1 1 0 is same as Row 3
and
here last 4 bits{ 4 to 7 } are 1 0 0 1 is flipped bits of Row 3 (which has 0 1 1 0)

Lets say A = 4 and B = 2 ---> answer should be = 1
so len = 8 and mid = 4
if B = 2 -> then  return ( my_subsequence_solve( A-1, B ) ); -> will return the answer
since, A-1 = 3 -> so in the 3rd row 2nd index bit is returned  = 1
final ans = 1

Lets say A = 4 and B = 5  ---> answer should be 0
so len = 8 and mid = 4
if B = 5 -> then  return ( 1- my_subsequence_solve( A-1, B-mid ) ); -> will return the answer
since, A-1 = 3 and B-mid = 5-4 = 1 -> so in the 3rd row 1st index bit will be returned = 1
1- (3rd row 1st index bit with having value) = 1 - 1 = 0
final ans = 0
 */

public class KthSymbol {

    public int solve(int A, int B) {

        if (A == 1) {
            return 0;
        }

        int len = (int) Math.pow(2, A - 1);

        int mid = len / 2;

        if (B < mid) {
            return solve(A - 1, B);
        } else {
            return (1 - solve(A - 1, B - mid));
        }
    }
}
