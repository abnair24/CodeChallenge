package com.abn.learn.dsa.day26Recursion2;

/*
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by
adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.

A = 83557

 1

 Sum of digits of (83557) = 28
 Sum of digits of (28) = 10
 Sum of digits of (10) = 1.
 Single digit is 1, so it's a magic number. Return 1.
 */
public class IsMagic {

    public int solve(int A) {

        return rec(A) == 1 ? 1 : 0;
    }

    private int rec(int A) {

        if(A >= 0 && A <= 9) {
            return A;
        }

        int sum = A % 10 + rec(A /10);
        return rec(sum);
    }

    public static void main(String[] args) {

        IsMagic isMagic = new IsMagic();
        System.out.println(isMagic.solve(835));
    }
}
