package com.abn.scalar.dsa.day27;

/*
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

Input 1:
A = 2
B = 3
C = 3

2
 */
public class PowerFunction {

    public int solve(int A, int B, int C) {

        if(A == 0)
            return 0;
        if(B == 0)
            return 1;
        long ans = solve(A, B / 2, C);
        ans = (ans * ans) % C;
        if(B % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return (int)ans;

    }

    public static void main(String[] args) {

        PowerFunction powerFunction = new PowerFunction();
        System.out.println(powerFunction.solve(-1, 3, 3));
        System.out.println(powerFunction.solve(2, 3, 3));
    }
}
