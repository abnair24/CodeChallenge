package com.abn.dsalgos.algo.recursion;

public class PrimeNumberCheckRecursion {

    private boolean isPrime(int number, int i) {

        if(number < 2) {
            return false;
        }

        if(i == 1) {
            return true;
        }

        if(number % i == 0) {
            return false;
        } else {
            return isPrime(number, i - 1);
        }
    }

    public boolean isPrimeCheck(int number) {

        return isPrime(number, number/2);
    }
}
