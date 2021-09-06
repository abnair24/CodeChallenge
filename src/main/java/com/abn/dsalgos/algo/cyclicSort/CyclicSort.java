package com.abn.dsalgos.algo.cyclicSort;

/*
Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.

assume we are passed an integer array containing only the sequence numbers

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]
 */
public class CyclicSort {

    public int[] cyclic(int[] array) {

        int i = 0;
        int len = array.length;

        while (i < len) {

            if (array[i] - 1 != i) {
                int temp = array[i];
                array[i] = array[temp - 1];
                array[temp - 1] = temp;
            } else {
                i++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        CyclicSort cyclicSort = new CyclicSort();
        System.out.println(cyclicSort.cyclic(new int[] {2, 6, 4, 3, 1, 5}));
    }
}
