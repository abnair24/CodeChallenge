package com.abn.learn.dsa.day27;

/*
Scooby has 3 three integers A, B, and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
You need to tell the number of special integers less than or equal to A.

A = 12
 B = 3
 C = 2

 o/p: 2
 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.

 */
public class Divisor {

    public int solve(int A, int B, int C) {

        int lcm = (B * C) / gcd(B, C);

        return A / lcm;
    }

    private int gcd(int b, int c) {

        if (c == 0 && b == 0) {
            return 0;
        }

        if (b == 0) {
            return c;
        }

        if (c == 0) {
            return b;
        }

        if (c == b) {
            return c;
        }

        if (c > b) {
            return gcd(c - b, b);
        } else {
            return gcd(c, b - c);
        }
    }

    public static void main(String[] args) {
        Divisor divisor = new Divisor();
        divisor.solve(12, 3, 2);
    }
}
