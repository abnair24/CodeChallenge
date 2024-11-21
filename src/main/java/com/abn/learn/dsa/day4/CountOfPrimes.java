package com.abn.learn.dsa.day4;

/*
You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
input = 19, output = 8
input = 1, output = 0
 */
public class CountOfPrimes {

    public int solve(int A) {

        int count = 0;

        for(int i = 2; i <= A; i ++) {
            if(isPrime(i)) {
                count ++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        int count = 0;

        if(n == 1) {
            return false;
        }

        if(n <= 0) {
            return false;
        }

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n %i == 0) {
                if(i * i == n) {
                    count ++;
                } else {
                    count += 2;
                }
            }
        }
        if(count == 2) {
            return true;
        } else {
            return false;
        }
    }
}
