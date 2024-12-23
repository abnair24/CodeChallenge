package com.abn.scalar.dsa.day3;

public class SumOfMaxMin {

    private int solve(int[] array) {

        int max = array[0];
        int min = array[0];

        int sum = 0;

        for(int i = 1; i< array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            } else if( array[i] < min) {
                min = array[i];
            }

        }

        sum = min + max;

        return sum;
    }

    public static void main(String[] args) {

        SumOfMaxMin sumOfMaxMin = new SumOfMaxMin();
        System.out.println(sumOfMaxMin.solve(new int[] {3, -3, 6, 8, 4, 7, 8, -2, 0}));
    }
}
