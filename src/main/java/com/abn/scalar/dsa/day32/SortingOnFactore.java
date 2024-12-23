package com.abn.scalar.dsa.day32;

/*
Given an array of size n, sort the data in ascending order of count
of factors, if count of factors are equal then sort the elements on
the basis of their magnitude.

A = [9, 3, 10, 6, 4]

No of factors:
9 -> (1, 3, 9) -> 3
3 -> (1, 3) -> 2
10 -> (1, 2, 5, 10) -> 4
6 -> (1, 2, 3, 6) -> 4
4 -> (1,2, 4) -> 3

output : 3, 4, 9, 6, 10
 */

import java.util.Arrays;
import java.util.Comparator;

public class SortingOnFactore {

    public int[] solve(int[] array) {

        Integer[] a = new Integer[array.length];

        for(int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }

        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (countFactor(x) == countFactor(y)) {
                    if (x < y) {
                        return -1;
                    } else if (x > y) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                if (countFactor(x) < countFactor(y)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i = 0; i < array.length;i++) {
            array[i] = a[i];
        }

        return array;
    }

    private int countFactor(int n) {

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if(n%i == 0) {
                if(n/i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        SortingOnFactore sortingOnFactore = new SortingOnFactore();
        System.out.println(Arrays.toString(sortingOnFactore.solve(new int[] {9, 3, 10, 6, 4})));
    }
}
