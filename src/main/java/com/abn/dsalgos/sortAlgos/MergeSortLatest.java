package com.abn.dsalgos.sortAlgos;

public class MergeSortLatest {

    public static void main(String[] args) {
        int [] array = new int[] {5,4,1,0,5,95,4,-100,200,0};

        int size = array.length;
        mergeSort(array, 0, size -1);
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if(left < right) {
            int mid = (left + right)/ 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    /*
     ________    _________
    | 4 | 5 |    | 0 | 1 |     => merging individually sorted elements.
    ---------    ---------
        \         /   /
         \       /   /
            ________________
     arr    | 0 | 1 | 4 | 5  |
            -----------------

    leftArr(4,5)
    rightArr(1,0)

     */

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftArraySize = mid - left +1;
        int rightArraySize = right - left;

        int[] leftArr = new int[leftArraySize];
        int[] rightArr = new int[rightArraySize];

        for(int i =0; i < leftArraySize; i++) {
            leftArr[i] = arr[left + i];
        }

        for(int j = 0; j < rightArraySize; j++){
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;


        while(i < leftArraySize && j < rightArraySize) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftArraySize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArraySize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
