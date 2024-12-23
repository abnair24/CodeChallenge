package com.abn.scalar.dsa.day23BitManipulation;

/*
You are given two integers A and B.
If B-th bit in A is set, make it unset.
If B-th bit in A is unset, leave as it is.
Return the updated A value.

Input 1:
A = 4
B = 1
Input 2:
A = 5
B = 2

Output 1:
4
Output 2:
1
 */
public class UnsetIthBit {

    public int solve(int N, int i) {

        int k = N & (1 << i);

        if(k > 0) {
            N = N ^ (1 << i);
        }
        return N;
    }

    public static void main(String[] args) {

        UnsetIthBit unsetIthBit = new UnsetIthBit();
        unsetIthBit.solve(4, 2);
    }
}
