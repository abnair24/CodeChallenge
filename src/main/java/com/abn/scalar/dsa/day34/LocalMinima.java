package com.abn.scalar.dsa.day34;

/*
Given an array of N distinct elements, find any local minima in the array
Local Minima - a no. which is smaller than its adjacent neighbors.

array = {3, 6, 1, 0, 9, 15, 8}

Approach:

case 1: (mid - 1 and mid + 1 ) > mid, return mid
case 2: mid -1 < mid, move left
case 3 : mid - 1 > mid, move right
 */
public class LocalMinima {

    public int solve(int[] array) {

        int high = array.length - 1;
        int low = 0;
        int mid;

        while(low <= high) {

            mid = low + (high - low)/2 ;

            if((mid == 0 || array[mid] < array[mid - 1]) && (mid == array.length - 1 || array[mid] < array[mid + 1])) {
                return array[mid];
            } else if(mid == 0 || array[mid] < array[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
