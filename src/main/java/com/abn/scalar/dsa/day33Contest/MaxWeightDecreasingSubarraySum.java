package com.abn.scalar.dsa.day33Contest;

public class MaxWeightDecreasingSubarraySum {

    public int solve(int[] A) {
        //[3,3,5,0,1]
        int len = A.length;
        if(len == 0) {
            return 0;
        }

        int max = 0;
        int current = A[0];

        for(int i = 1; i < len; i++) {
            if(A[i] < A[i-1]) {
                current += A[i];
            } else {
                max = Math.max(max, current);
                current = A[i];
            }
        }

        max = Math.max(max, current);
        return max;
    }
}
