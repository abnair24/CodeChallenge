package com.abn.dsalgos.algo.greedy;

/*
Given the number of digits and the sum of the digits, find the largest number that can be created.


 */
public class LargestNumber {

    public int getLargeNumber(int digits, int sum) {

        int num = 0;
        int[] result = new int[digits];

        int maxDigit = 9;


        for (int i = 0; i < digits; i++) {

            if (sum >= 9) {
                result[i] = 9;
                sum = sum - 9;
            } else {
                result[i] = sum;
                sum = 0;
            }
        }

        for (int i = digits - 1; i >= 0; i--) {
            num += result[digits - 1 - i] * Math.pow(10, i);
        }

        return num;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.getLargeNumber(4, 30));
    }
}
