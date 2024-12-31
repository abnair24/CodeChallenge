package com.abn.scalar.dsa.day34;

/*
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider
only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Input 1:

A = [1, 2, 3, 4, 5]
Output 1: 5

Input 2:

A = [5, 17, 100, 11]
output: 100

 */
public class LocalMaxima {

    public int solve(int[] array) {
        int high = array.length - 1;
        int low = 0;
        int mid;

        while(low <= high) {

            mid = low + (high - low)/2 ;

            if((mid == 0 || array[mid] >= array[mid - 1]) && (mid == array.length - 1 || array[mid] >= array[mid + 1])) {
                return array[mid];
            } else if(mid == 0 || array[mid] > array[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        LocalMaxima localMaxima = new LocalMaxima();
        System.out.println(localMaxima.solve(new int[] {1, 100000, 100000}));
    }
}
