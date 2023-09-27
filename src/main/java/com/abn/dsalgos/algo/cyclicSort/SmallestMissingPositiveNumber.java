package com.abn.dsalgos.algo.cyclicSort;

/*
Given an unsorted array containing numbers, find the smallest missing positive number in it.
 */
public class SmallestMissingPositiveNumber {

    public int smallestMissing(int[] array) {

        int i = 0;
        while (i < array.length) {
            if (array[i] > 0 && array[i] <= array.length && array[i] != array[array[i] - 1]) {
                int j = array[i] - 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < array.length; k++) {
            if (array[k] != k + 1) {
                return k + 1;
            }
        }

        return array.length + 1;
    }

    public static void main(String[] args) {
        SmallestMissingPositiveNumber smallestMissingPositiveNumber = new SmallestMissingPositiveNumber();
        System.out.println(smallestMissingPositiveNumber.smallestMissing(new int[] {-3, 1, 5, 4, 2}));
        System.out.println(smallestMissingPositiveNumber.smallestMissing(new int[] {-1, -3}));
        System.out.println(smallestMissingPositiveNumber.smallestMissing(new int[] {1, 2, 3}));
        System.out.println(smallestMissingPositiveNumber.smallestMissing(new int[] {1, 3, 6, 4, 8, 2}));

    }
}
