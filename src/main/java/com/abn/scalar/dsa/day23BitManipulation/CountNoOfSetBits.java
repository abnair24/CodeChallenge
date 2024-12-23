package com.abn.scalar.dsa.day23BitManipulation;

/*
Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

Input 1:
11
Input 2:
6

Output 1:
3
Output 2:
2

 */
public class CountNoOfSetBits {

    public int solve(int n) {

        int count = 0;

        while(n>0) {
            if((n & 1) > 0) {
                count ++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {

        CountNoOfSetBits countNoOfSetBits = new CountNoOfSetBits();
        countNoOfSetBits.solve(7);
    }
}
