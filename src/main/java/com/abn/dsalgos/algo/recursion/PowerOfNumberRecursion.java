package com.abn.dsalgos.algo.recursion;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
public class PowerOfNumberRecursion {

    /*
    recursive approach:
    time complexity : 0(logN) (Since only half of the number is looped through
    space complexity : 0(logN)
     */

    public double powRec(double x, int n) {

        long pow = n;
        if (n < 0) {
            pow = -pow;
            x = 1 / x;
        }

        return getPower(x, pow);
    }

    private double getPower(double x, long n) {

        if (n == 0 ) {
            return 1.0;
        }

        double half = getPower(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /*
    Iterative approach
    Time complexity : O(logN)
    Space complexity : 0(1)
     */

    public double powIter(double x, int n) {

        long pow = n;
        if (n < 0) {
            pow = -pow;
            x = 1 / x;
        }

        double prod = x;
        double oddProd = 1;

        for (long i = pow; i > 0; i /= 2) {

            if ((i % 2) == 1) {
                oddProd = oddProd * prod;
            }
            prod = prod * prod;
        }
        return oddProd;
    }
}
