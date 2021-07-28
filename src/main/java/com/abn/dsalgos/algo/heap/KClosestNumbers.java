package com.abn.dsalgos.algo.heap;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

Input: [5, 6, 7, 8, 9], K = 3, X = 7
Output: [6, 7, 8]

Input: [2, 4, 5, 6, 9], K = 3, X = 10
Output: [5, 6, 9]
 */
public class KClosestNumbers {

    public List<Integer> kClosest(int[] array, int x, int k) {

        List<Integer> result = new ArrayList<>();

        int index = binarySearch(array, x);

        int left = index;
        int right = index + 1;

        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < array.length) {

                int leftDiff = Math.abs(x - array[left]);
                int rightDiff = Math.abs(x - array[right]);

                if (leftDiff <= rightDiff) {
                    result.add(0, array[left]);
                    left--;
                } else {
                    result.add(array[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, array[left]);
                left--;
            } else if (right < array.length) {
                result.add(array[right]);
                right++;
            }
        }
        return result;
    }

    private int binarySearch(int[] array, int x) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low > 0) {
            return low - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        KClosestNumbers kClosestNumbers = new KClosestNumbers();
        System.out.println(kClosestNumbers.kClosest(new int[] {1, 2, 3, 4, 5}, 3, 4));
    }
}
