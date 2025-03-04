package com.abn.scalar.dsa.day58;

import java.util.Arrays;

/*
Given an array representing a max heap, convert this into a min heap.
input : [30, 28, 26, 24, 25, 20, 18, 14, 16]

o/p: [14, 16, 18, 24, 25, 20, 26, 30, 28
 */
public class ConvertMaxHeapToMinHeap {

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
                int temp = array[index];
                array[index] = array[smallest];
                array[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public int[] maxToMinHeap(int[] array) {

        for(int i = (array.length - 1) /2; i >= 0; i --) {
            minHeapify(array, i, array.length);
        }
        return array;
    }

    public static void main(String[] args) {

        ConvertMaxHeapToMinHeap convertMaxHeapToMinHeap = new ConvertMaxHeapToMinHeap();
        System.out.println(Arrays.toString(convertMaxHeapToMinHeap.maxToMinHeap(new int[] {30, 28, 26, 24, 25, 20, 18, 14, 16})));
    }
}
