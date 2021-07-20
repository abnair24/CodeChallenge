package com.abn.dsalgos.algo.binarySearch;

import java.util.Arrays;

/*
Inversion count represents how far or close an array is from being sorted.
 If an array is sorted, the inversion count is 0. But if it’s sorted in the reverse order,
 the inversion count is maximum.

 (9, 5, 6, 11, 8, 10)

 Number of inversions = 5

 i-e: (9, 5), (9, 6), (9, 8), (11, 8), (11, 10)
 */
public class InversionCount {

//    public static int countInversionsUtil(int arr[], int temp[], int left, int right) {
//
//        int mid, invCount = 0;
//        if (right > left) {
//
//            mid = (right + left) / 2;
//
//            // Inversion count is the sum of inversions in left-part + right-part + number of inversions in merge phase
//            invCount = countInversionsUtil(arr, temp, left, mid);
//            invCount += countInversionsUtil(arr, temp, mid + 1, right);
//
//            // Merge both parts
//            invCount += merge(arr, temp, left, mid + 1, right);
//        }
//        return invCount;
//    }
//
//    // This method will merge two sorted arrays and return the inversion count
//    public static int merge(int arr[], int temp[], int left, int mid, int right) {
//
//        int invCount = 0;
//
//        int i = left; // for left subarray
//        int j = mid; // for right subarray
//        int k = left; // for resultant merged subarray
//        while ((i <= mid - 1) && (j <= right)) {
//
//            if (arr[i] <= arr[j])
//                temp[k++] = arr[i++];
//
//            else {
//
//                temp[k++] = arr[j++];
//                invCount = invCount + (mid - i);
//            }
//        }
//
//        return invCount;
//    }
//
//    // wrapper function for countInversionsUtil
//    public static int countInversions(int arr[]) {
//
//        int size = arr.length;
//        int temp[] = new int[size];
//        return countInversionsUtil(arr, temp, 0, size - 1);
//    }
//    int count = 0;
//
//    public int[] mergeSort(int[] input) {
//
//        if(input.length <= 1) {
//            return input;
//        }
//        int middle = input.length / 2;
//        int len = input.length;
//
//        int[] left = mergeSort(Arrays.copyOfRange(input, 0, middle));
//        int[] right = mergeSort(Arrays.copyOfRange(input, middle, len));
//
//        return merge(left, right);
//    }
//
//    private int[] merge(int[] left, int[] right) {
//
//        int[] result = new int[left.length + right.length];
//
//        int leftIndex = 0;
//        int rightIndex = 0;
//        int resultIndex = 0;
//
//        while(leftIndex < left.length && rightIndex < right.length) {
//            if(left[leftIndex] < right[rightIndex]) {
//                result[resultIndex ++] = left[leftIndex ++];
//            } else {
//                result[resultIndex ++] = right[rightIndex ++];
//                count = count ++;
//            }
//        }
//
//        while(leftIndex < left.length) {
//            result[resultIndex ++] = left[leftIndex ++];
//        }
//        while(rightIndex < right.length) {
//            result[resultIndex ++] = right[rightIndex ++];
//        }
//
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("Given Array Inversion Count\n");
//
//        int[] arr = {2, 3, 8, 4};
//        InversionCount inversionCount = new InversionCount();
//        inversionCount.mergeSort(arr);
//    }
}
