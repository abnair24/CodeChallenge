package com.abn.scalar.dsa.day33Contest;



public class XOR {

    public int[] solve(int[] A, int[] B) {

        int[] result = new int[B.length];
        for(int i = 0; i < B.length; i++) {
            result[i] = countSetBit(A, B[i]);
        }
        return result;
    }

    private int countSetBit(int[] array, int i) {
        int countOne = 0;
        int countZero = 0;
        for(int n : array) {

            if((n & (1 << i)) != 0) {
                countOne ++;
            } else {
                countZero ++;
            }
        }

        return countOne * countZero; // Check for how many number has 1 in ith bit and how many has 0 at ith bit.
    }
}
