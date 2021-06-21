package com.abn.dsalgos.algo.binarySearch;



/*
           1. Sorted array : 4,5,6,7,8,9,11,20,23
              Rotated array (input) : 11,20,23,4,5,6,7,8,9
              Search key : 4

           2. Sorted array : [0,1,2,4,5,6,7]
              Rotated array (input) : 4,5,6,7,0,1,2
              Search key : 0
 */


public class SearchInRotatedArray {


    public int search(int array[], int low, int high, int key) {
        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (array[middle] == key) {
            return middle;
        }
        /*
        Check whether first half is sorted from middle.
         */
        if (array[low] <= array[middle]) {

            /*
            Checking for key in sorted subarray in left or right
             */
            if (key >= array[low] && key <= array[middle]) {
                return search(array, low, middle - 1, key);
            }

            return search(array, middle + 1, high, key);
        }

        /*
        If array[0 ... mid ] is not sorted , then next half must be sorted. Checking key belongs to next half
         */
        if (key > array[middle] && key <= array[high]) {
            return search(array, middle + 1, high, key);
        }

        /*
        if key doesnt belong to second half, then search in first itself.
         */
        return search(array, low, middle - 1, key);
    }
}
