package com.abn.dsalgos.algo.binarySearch;

/*
Implement a function that tells whether a given target is present in the sorted matrix or not.

matrix  = {
            {10, 11, 12, 13},
            {14, 15, 16, 17},
            {27, 29, 30, 31},
            {32, 33, 39, 80}
          };

target = 30

output : true

Since matrix is sorted one, BS can be used.

Visualize matrix as a 1-d array

=> 10, 11, 12, 13, 14, 15, 16, 17, 27, 29, 30, 31, 32, 33, 39, 80

length = row * col -1
mid = (start + length) /2

 */
public class SearchInSortedMatrix {

    public boolean search(int[][] matrix, int target) {

        int col = matrix[0].length;
        int row = matrix.length;

        int start = 0;
        int end = row * col - 1;

        int mid, midElement;

        while(start <= end) {

            mid = (start + end) / 2;
            midElement = matrix[mid / col][mid % col];

            if(target < midElement) {
                end = mid - 1;
            } else if(target > midElement) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
