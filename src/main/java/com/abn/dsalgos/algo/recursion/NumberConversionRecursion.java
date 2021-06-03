package com.abn.dsalgos.algo.recursion;

public class NumberConversionRecursion {

    public int decToBin(int number) {

        if (number <= 1) {
            return number;
        } else {

            return number % 2 + 10 * decToBin(number / 2);
        }
    }
}
