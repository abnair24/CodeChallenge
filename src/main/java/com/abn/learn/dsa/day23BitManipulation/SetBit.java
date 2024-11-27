package com.abn.learn.dsa.day23BitManipulation;

/*
You are given two integers A and B.
Set the A-th bit and B-th bit in 0, and return output in decimal Number System.

Note:
The bit positions are 0-indexed, which means that the least significant bit (LSB) has index 0.

Input 1:
A = 3
B = 5
Input 2:
A = 4
B = 4

Output 1:
40
Output 2:
16
 */
public class SetBit {

    public int solve(int A, int B) {
        return (1 << A) | (1 << B);
    }

    public static void main(String[] args) {

        SetBit setBit = new SetBit();
        System.out.println(setBit.solve(8, 5));
    }
}
