package com.abn.scalar.dsa.day13;

import java.util.Arrays;

public class NobleInteger {

    public int solve(int[] array) {

        int len = array.length;
        Arrays.sort(array);
        int count = 0;
        int ans = 0;

        if(array[len - 1] == 0) {
            return 1;
        }

        for(int i = len-2; i >= 0; i --) {
            if(array[i] != array[i+1]) {
                count = len - i - 1;
            }

            if(count == array[i]) {
                return 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        NobleInteger nobleInteger = new NobleInteger();
        System.out.println(nobleInteger.solve(new int[] {1, 2, 3, 4, 4, 5, 6, 6}));
        System.out.println(nobleInteger.solve(new int[] {3, 2, 1, 3}));
        System.out.println(nobleInteger.solve(new int[] {-1, -2, 0, 0, 0, -3}));

        System.out.println(nobleInteger.solve(new int[] {-4, -2, 0, -1, -6}));
        System.out.println(nobleInteger.solve(new int[] {1, 1, 3, 3}));
    }
}
