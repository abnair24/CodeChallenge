package com.abn.scalar.dsa.day23BitManipulation;

/*
Given an integer A, find and return the Ath magic number.

A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Analysis:

index : 0   1   2   3   4   5   6   7   8   9
num:    5   25  30  125 130 150 155 625 630 650
A       1   2   3   4   5   6   7   8   9   10

A: 1:  5*1           00000001
A: 2:  5*2           00000010
A: 3:  5*2 + 5*1     00000011
A: 4:  5*3           00000100
A: 5:  5*3 + 5*1     00000101
A: 6:  5*3 + 5*2     00000110
A: 7:  5*3 + 5*2 + 5 00000111

 */

public class MagicNumber {

    public int magicNumber(int A) {

        int ans = 0;

        for(int i = 0; i < 32; i++) {
            int k = A & (1 << i);
            if(k > 0) {
                ans += Math.pow(5, i+1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        MagicNumber magicNumber = new MagicNumber();
        System.out.println(magicNumber.magicNumber(3));
    }
}
