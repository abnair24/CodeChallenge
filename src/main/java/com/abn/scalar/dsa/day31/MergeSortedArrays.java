package com.abn.scalar.dsa.day31;

public class MergeSortedArrays {

    public int[] solve(final int[] nums1, final int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] tempNums1 = new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tempNums1[k] = nums1[i];
                i++;
            } else {
                tempNums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            tempNums1[k] = nums1[i];
            k++;
            i++;
        }

        while (j < n) {
            tempNums1[k] = nums2[j];
            k++;
            j++;
        }

        return tempNums1;

    }

    public static void main(String[] args) {

        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.solve(new int[] {-4, 3}, new int[] {-2, -2});
    }
}
