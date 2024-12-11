package com.abn.learn.dsa.day27;

import com.beust.ah.A;

/*
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

Approach:

A % M = A - (Largest multiple of M < A)
B % M = B - (Largest multiple of M < B)

A%M = B%M
A - (Largest multiple of M < A) = B - (Largest multiple of M < B)
A - M x X1 = B - M x X2

A - B = M(X1 - X2)
M = (A -B) /(X1-X2)

For M to be maximum, X1-X2 to be minimum. so minimum =1.
thus M = A - B;

A = 5
B = 10

5

 */
public class ABModulo {

    public int solve(int A, int B) {
        if(A > B) {
            return A -B;
        } else if(B > A){
            return B - A;
        } else {
            return A;
        }
    }

    public static void main(String[] args) {

        ABModulo abModulo = new ABModulo();
        abModulo.solve(5, 7);
        abModulo.solve(5, 9);
    }
}
