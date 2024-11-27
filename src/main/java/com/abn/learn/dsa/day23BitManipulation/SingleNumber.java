package com.abn.learn.dsa.day23BitManipulation;

public class SingleNumber {

    public int singleNumber(final int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result = result ^ A[i];
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber(new int[] {1, 2, 3, 4, 2, 3, 4});
    }
}
