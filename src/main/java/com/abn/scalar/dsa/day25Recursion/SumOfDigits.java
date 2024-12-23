package com.abn.scalar.dsa.day25Recursion;

public class SumOfDigits {

    public int sum(int N) {
        if(N == 0) {
            return 0;
        }

        return N % 10 + sum(N/10);
    }

    public static void main(String[] args) {

        SumOfDigits sumOfDigits = new SumOfDigits();
        System.out.println(sumOfDigits.sum(254));
    }
}
