package com.abn.dsalgos.algo;


/*
Find the maximum SubArray sum possible using kadane's algorithm
 */
public class MaxSubArraySum {

    public int maxSum(int[] array) {

        // {-1,4,3,-1}
        int localMax = array[0];
        int globMax = array[0];

        for(int i=1; i<array.length;i++) {
            localMax =Math.max(array[i],localMax + array[i]);
            globMax = Math.max(localMax, globMax);
        }

        return globMax;
    }

}
