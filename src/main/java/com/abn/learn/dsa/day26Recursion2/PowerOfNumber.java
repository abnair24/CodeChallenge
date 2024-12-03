package com.abn.learn.dsa.day26Recursion2;

/*
Given 2 integers a & n find a^n using recursion

a =2, n = 3
a^n = 2^3 = 8
 */
public class PowerOfNumber {

    public int solve(int a, int n) {
        if(n == 0) {
            return 1;
        }

        int p = solve(a, n/2);

        if(n % 2 == 0) {
            return p * p;
        } else {
            return p * p * a;
        }

    }

    public static void main(String[] args) {

        PowerOfNumber powerOfNumber = new PowerOfNumber();
        System.out.println(powerOfNumber.solve(2, 5));
    }
}
