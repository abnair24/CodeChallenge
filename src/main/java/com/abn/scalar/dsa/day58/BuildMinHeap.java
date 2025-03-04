package com.abn.scalar.dsa.day58;

import java.util.Arrays;

/*
Given an array A of N integers, convert that array into a min heap and return the array.

NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.

A = [5, 13, -2, 11, 27, 31, 0, 19]
 */
public class BuildMinHeap {

    public int[] buildHeap(int[] A) {

        for(int i = (A.length-1)/2; i >= 0; i--) {
            minHeapify(A, i, A.length);
        }

        return A;
    }

    private void minHeapify(int[] array, int index, int heapSize) {

        int smallest = index;
        while(index < heapSize/2) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if(left < heapSize && array[index] > array[left]) {
                smallest = left;
            }

            if(right < heapSize && array[smallest] > array[right]) {
                smallest = right;
            }

            if(smallest != index) {
                //swap

                int temp = array[index];
                array[index] = array[smallest];
                array[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        BuildMinHeap buildMinHeap = new BuildMinHeap();
        System.out.println(Arrays.toString(buildMinHeap.buildHeap(new int[] {5, 13, -2, 11, 27, 31, 0, 19})));
    }
}
