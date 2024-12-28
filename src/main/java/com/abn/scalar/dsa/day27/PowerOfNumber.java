package com.abn.scalar.dsa.day27;

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
        System.out.println(powerOfNumber.power(2, 3));
        System.out.println(powerOfNumber.power(1, -20));
        System.out.println(powerOfNumber.power(-2, 3));
    }
}
