package com.abn.sc.dsa.day66;

/*
Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series
 are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.

Input 1:

 A = 4
Input 2:

 A = 6


Example Output

Output 1:

 3
Output 2:

 8
 */
public class FibonacciNumber {

    public static final int MAX = 100;

    public static int[] arr;

    public int fibTopDown(int n) {
        if (arr[n] == -1) {
            if (n <= 1) {
                arr[n] = n;
            } else {
                arr[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = -1;
        }

        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fibTopDown(4));
        System.out.println(fibonacciNumber.fibTopDown(6));
    }
}
