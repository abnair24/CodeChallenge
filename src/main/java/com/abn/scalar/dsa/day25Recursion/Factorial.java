package com.abn.scalar.dsa.day25Recursion;

public class Factorial {

    public int factorial(int N) {

        if(N == 0) {
            return 1;
        }

        return N * factorial(N-1);
    }

    public static void main(String[] args) {

        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(5));
        System.out.println(factorial.factorial(1));

    }
}
