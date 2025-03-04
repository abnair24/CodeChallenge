package com.abn.scalar.dsa.day58;

import java.util.Arrays;

public class BuildMaxHeap {

    public int[] buildHeap(int[] A) {
        for(int i = (A.length-1)/2; i >= 0; i--) {
            maxHeapify(A, i, A.length);
        }

        return A;
    }

    private void maxHeapify(int[] array, int index, int heapSize) {

        int largest = index;
        while(index < heapSize/2) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if(left < heapSize && array[index] < array[left]) {
                largest = left;
            }

            if(right < heapSize && array[largest] < array[right]) {
                largest = right;
            }

            if(largest != index) {
                //swap

                int temp = array[index];
                array[index] = array[largest];
                array[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        BuildMaxHeap maxHeap = new BuildMaxHeap();
        System.out.println(Arrays.toString(maxHeap.buildHeap(new int[] {1, 4, 7, 12, 15, 14, 9, 2, 3, 16})));
    }
}
