package com.abn.scalar.dsa.day32;

import java.util.Arrays;

public class SmallestNumber {

    public int[] smallesNumber(int[] array) {
        int[] freq = new int[10];

        for(int i = 0; i < array.length; i++) {
            freq[array[i]]++;
        }

        int index = 0;
        for(int i = 0; i < freq.length; i++) {
            while(freq[i] > 0) {
                array[index++] = i;
                freq[i] --;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(Arrays.toString(smallestNumber.smallesNumber(new int[] {6,3,4,2,7,2,1})));
    }
}
