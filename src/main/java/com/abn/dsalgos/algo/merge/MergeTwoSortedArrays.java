package com.abn.dsalgos.algo.merge;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MergeTwoSortedArrays {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tempNums1 = new int[m + n];

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
}
