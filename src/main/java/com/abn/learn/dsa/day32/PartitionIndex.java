package com.abn.learn.dsa.day32;

/*

Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:

if A[i] < p then it should be present on left side of the partition
if A[i] > p then it should be present on right side of the partition

A = [6, 2, 0, 4, 5]
 */
public class PartitionIndex {

    public int solve(int[] array) {
        int len = array.length;

        int pivotIndex = len - 1;
        int leftPtr = 0;
        int rightPtr = len - 2;

        while(leftPtr <= rightPtr) {

            if(array[leftPtr] <= array[pivotIndex]) {
                leftPtr ++;
            } else if(array[rightPtr] > array[pivotIndex]) {
                rightPtr --;
            } else {
                swap(array, leftPtr, rightPtr);
            }
        }

        swap(array, leftPtr, pivotIndex);

        return leftPtr;
    }

    private int[] swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        return array;
    }

    public static void main(String[] args) {
        PartitionIndex partitionIndex = new PartitionIndex();
        partitionIndex.solve(new int[] {12, 25, 6, 37, 11, 44, 41, 4, 38});
    }
}
