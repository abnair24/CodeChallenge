package com.abn.scalar.dsa.day48Lab;

/*
A lucky number is a number that has exactly 2 distinct prime divisors.

You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

A = 8
o/p: 1

Between [1, 8] there is only 1 lucky number i.e 6.
6 has 2 distinct prime factors i.e 2 and 3.

A = 12
o/p: 3

Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumber {

    public int solve(int A) {

        int count = 0;

        for(int number : getPrimeFactors(A)) {
            if(number == 2) {
                count ++;
            }
        }

        return count;
    }

    private int[] getPrimeFactors(int A) {

        int[] sieve = new int[A + 1];

        for(int i = 2; i <= A; i++) {
            if(sieve[i] == 0) {
                for(int j = i;  j <= A; j = j+i) {
                    sieve[j] = sieve[j] + 1;
                }
            }
        }
        return sieve;
    }

    public static void main(String[] args) {

        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.solve(12);
    }
}
