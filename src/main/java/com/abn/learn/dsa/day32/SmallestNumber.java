package com.abn.learn.dsa.day32;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestNumber {

    public int[] smallesNumber(int[] array) {
        Integer[] a = new Integer[array.length];

        for(int i = 0; i < array.length; i++) {

            a[i] = array[i];
        }

        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                String xy = x + String.valueOf(y);
                String yx = y + String.valueOf(x);

                return xy.compareTo(yx) < 0 ? -1 : 1;

            }});

        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            result[i] = Integer.valueOf(a[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(smallestNumber.smallesNumber(new int[] {3,30,34,5,9}));
        System.out.println(smallestNumber.smallesNumber(new int[] {10,5, 2, 8, 200}));
    }
}
