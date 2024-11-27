package com.abn.learn.dsa.day23BitManipulation;

import org.checkerframework.checker.units.qual.C;

/*
You are given two integers A and B.
Return 1 if B-th bit in A is set
Return 0 if B-th bit in A is unset
Note:
The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.

Example Input

Input 1:
A = 4
B = 1

Output 1:
0

Input 2:
A = 5
B = 2

Output 2:
1
 */
public class CheckBit {

    public int solve(int N, int i) {
        int k = N & (1 << i);
        return k > 0 ? 1 : k;
    }

    public static void main(String[] args) {
        CheckBit checkBit = new CheckBit();
        checkBit.solve(4, 1);
    }
}
