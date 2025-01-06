package com.abn.scalar.dsa.day34;

import java.util.Arrays;

/*
iven a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a
given integer B in the array A.

Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Note: The time complexity of your algorithm must be O(log n)..

A = [5, 7, 7, 8, 8, 10]
 B = 8
 [3, 4]

A = [5, 17, 100, 111]
 B = 3

  [-1, -1]
 */
public class SearchRange {

    public int[] solve(int[] array, int target) {

        int[] result = new int[] {-1, -1};
        int lowIndex = getLowIndex(array, target);
        int highIndex = getHighIndex(array, target);

        result[0] = lowIndex;
        result[1] = highIndex;

        return result;
    }

    private int getLowIndex(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;
        int mid;
        int ans = -1;

        while(low <= high) {
            mid = (low + (high - low)/ 2);

            if(array[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if(array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int getHighIndex(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;
        int mid;
        int ans = -1;

        while(low <= high) {
            mid = (low + (high - low)/ 2);

            if(array[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if(array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.solve(new int[] {5, 17, 100, 111}, 3)));
    }
}
