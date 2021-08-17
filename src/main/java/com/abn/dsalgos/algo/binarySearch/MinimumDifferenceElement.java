package com.abn.dsalgos.algo.binarySearch;

/*
Given an array of integers sorted in ascending order, and a target value, find the element
in the array that has minimum difference with the target value.

Input: a[] = [2, 5, 10, 12, 15], target = 6
Output: 5

Input: a[] = [2, 5, 10, 12, 15], target = 5
output : 5

Input: a[] = [2, 5, 10, 12, 15], target = 8
output : 10

Input: a[] = [2, 5, 10, 12, 15], target = 11
output : 12

 */
public class MinimumDifferenceElement {

    public int minimumDifference(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(target == array[mid]) {
                return array[mid];
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if((array[low] - target) < (target - array[high])) {
            return array[low];
        }
        return array[high];
    }

    public static void main(String[] args) {
        MinimumDifferenceElement minimumDifferenceElement = new MinimumDifferenceElement();
        System.out.println(minimumDifferenceElement.minimumDifference(new int[] {2, 5, 10, 12, 15}, 8));
    }


}
