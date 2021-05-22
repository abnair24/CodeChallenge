package com.abn.dsalgos.algo;

/*
  Find max product of consecutive subarray

a: [-4, -2, 10, 20, -3]
 o/p : 1600

 */
public class MaxSubArrayProduct {

    public long maxProduct(long[] array) {

        long localMax = array[0];
        long localMin = array[0];
        long maxProd = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                localMax = Math.max(localMax * array[i], array[i]);
                localMin = Math.min(localMin * array[i], array[i]);
            } else {
                long localMaxNeg = Math.max(localMin * array[i], array[i]);
                localMin = Math.min(localMax * array[i], array[i]);
                localMax = localMaxNeg;
            }
            maxProd = Math.max(maxProd, localMax);
        }
        return maxProd;
    }
}
