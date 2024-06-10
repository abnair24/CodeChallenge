package com.abn.dsalgos.codility;

/*
Given an integer N, print another which was formed by reversing decimal representation of N. The leading zeros of resulting integer should not be printed.

Eg:
N = 54321 : O/P: 12345
N = 11000 : O/P: 11
N = 1 : O/P: 1
 */

public class ReverseNumberFromDecimal {

    public void reversedNumber(int n) {

        int enabled = n % 10;
        while(n > 0) {
            if(enabled == 0 && n % 10 != 0) {
                enabled = 1;
            }
            if(enabled >= 1) {
                System.out.print(n%10);
            }
            n = n/10;
        }
    }

    public static void main(String[] args) {

        ReverseNumberFromDecimal reverseNumberFromDecimal = new ReverseNumberFromDecimal();
        reverseNumberFromDecimal.reversedNumber(50);
        reverseNumberFromDecimal.reversedNumber(505);

    }
}
