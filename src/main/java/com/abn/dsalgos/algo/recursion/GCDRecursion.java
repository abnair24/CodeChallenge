package com.abn.dsalgos.algo.recursion;

public class GCDRecursion {

    public int gcd(int num1, int num2) {

        if (num1 == 0 && num2 == 0) {
            return 0;
        }

        if (num1 == 0) {
            return num2;
        } else if (num2 == 0) {
            return num1;
        }

        if (num1 == num2) {
            return num1;
        }

        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        } else {
            return gcd(num1, num2 - num1);
        }
    }

    public static void main(String[] args) {

        GCDRecursion gcdRecursion = new GCDRecursion();
        System.out.println(gcdRecursion.gcd(25, 60));
    }
}
