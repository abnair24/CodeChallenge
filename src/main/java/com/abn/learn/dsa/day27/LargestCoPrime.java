package com.abn.learn.dsa.day27;

import java.util.HashMap;
import java.util.Map;

/*
You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1

A = 30
 B = 12

  All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
 The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
 */
public class LargestCoPrime {

    public int cpFact(int a, int b) {
        while(gcd(a, b)!= 1) {
            a = a/gcd(a,b);
        }
        return a;
    }

    private int gcd(int a, int b) {

        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        LargestCoPrime largestCoPrime = new LargestCoPrime();
        System.out.println(largestCoPrime.cpFact(30, 12));
    }
}
