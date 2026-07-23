package com.abn.sc.dsa.day26Recursion2;

/*
Given 2 integers a & n find a^n using recursion

a =2, n = 3
a^n = 2^3 = 8
 */
public class PowerOfNumber {

    public long power(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        if(exponent < 0) {
            return 1 / power(base, -exponent);
        } else {
            long half = power(base, exponent / 2);

            if (exponent % 2 == 0) {
                return half * half;
            } else {
                return base * half * half;
            }
        }
    }

    public static void main(String[] args) {

        PowerOfNumber powerOfNumber = new PowerOfNumber();
        System.out.println(powerOfNumber.power(2, 5));
    }
}
