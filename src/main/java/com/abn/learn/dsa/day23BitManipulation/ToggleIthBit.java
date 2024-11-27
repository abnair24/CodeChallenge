package com.abn.learn.dsa.day23BitManipulation;

/*
You are given two integers A and B.
If B-th bit in A is set, make it unset
If B-th bit in A is unset, make it set
Return the updated A value

Input 1:
A = 4
B = 1

Input 2:
A = 5
B = 2

Output 1:
6
Output 2:
1
 */
public class ToggleIthBit {

    public int solve(int N, int i) {

        N = N ^ (1 <<i);
        return N;
    }

    public static void main(String[] args) {
        ToggleIthBit toggleIthBit = new ToggleIthBit();
        toggleIthBit.solve(4, 1);
    }
}
