package com.abn.scalar.dsa.day25Recursion;

public class Print1toN {

    public void rec(int A) {
        if(A == 0) {
            return;
        }
        rec(A - 1);
        System.out.print(A + " ");
    }

    public void solve(int A) {
       rec(A);
        System.out.println();
    }

    public static void main(String[] args) {
        Print1toN print1toN = new Print1toN();
        print1toN.solve(9);
    }
}
