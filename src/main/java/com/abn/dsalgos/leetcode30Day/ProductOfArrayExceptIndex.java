package com.abn.dsalgos.leetcode30Day;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptIndex {

    // [1,2,3,4,5]
    // [120,60,40,30,24]

    public int[] productArray(int[] array) {

        int len = array.length;
        int product = 1;
        int p = 0;
        int[] ouput = new int[len];

        for (int i = 0; i < len; i++) {

            p = 1;
            if (i != 0) {
                product = product * array[i - 1];
            }
            for (int j = len - 1; j > i; j--) {
                p = p * array[j];
            }
            p = p * product;
            ouput[i] = p;
        }

        return ouput;
    }

}
