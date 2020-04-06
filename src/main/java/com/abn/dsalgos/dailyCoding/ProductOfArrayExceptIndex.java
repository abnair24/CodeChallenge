package com.abn.dsalgos.dailyCoding;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptIndex {

    // [1,2,3,4,5]
    // [120,60,40,30,24]

    public static void productArray(int[] array) {

        int len = array.length;
        int product = 1;
        int p = 1;
        List<Integer> productList = new ArrayList<>();

        for(int i =0;i<len;i++) {

            p = 1;

            if(i != 0) {
                product = product * array[i-1];
            }
            for(int j= len-1;j>i;j--) {
                p = p* array[j];
            }

            p = p * product;
            productList.add(i,p);
        }

        for(int i=0; i<productList.size();i++) {
            System.out.print(productList.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int[] array = new int[] {5,-4,0};
        productArray(array);
    }
}
