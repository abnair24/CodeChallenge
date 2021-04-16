package com.abn.dsalgos.algo.merge;

public class MergeTwoSortedArrays {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int [] tempNums1 = new int[m];

        for(int i=0; i< m; i++) {
            tempNums1[i] = nums1[i];
        }

        int i =0;
        int j =0;
        int k = 0;

        while(i < m && j < n) {
            if(tempNums1[i] <= nums2[j]) {
                nums1[k] = tempNums1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m) {
            nums1[k] = tempNums1[i];
            k++;
            i++;
        }

        while(j < n){
            nums1[k] = nums2[j];
            k++;
            j++;
        }

        return nums1;
    }
}
