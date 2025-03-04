package com.abn.scalar.dsa.day58;

import java.util.PriorityQueue;

/*
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any
one of the N elements and add the original value(value stored at the
index before we did any operations) to its current value. You can choose any of the N elements in each operation.
Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.

Input 1:

 A = [1, 2, 3, 4]
 B = 3

 Output 1:

 4

Input 2:

 A = [5, 1, 4, 2]
 B = 5

 Output 2:

 5


 Approach:
  Idea: We will use a min-heap (priority queue) to manage the next possible values of all elements
  in the array after each operation.
  The original array will remain unchanged because we need to reference the initial values for each operation.
  We will maintain a separate array to track the current state of elements after every operation.


Initialize a priority queue to store pairs of the next possible value and its corresponding index in the array.

For each element in the array, calculate the first possible value (current value + original value) and add
it to the priority queue.

Perform B operations where each operation involves:
a. Extracting the minimum value from the priority queue.

b. Updating the current state array at the extracted index by adding the original value.

c. Calculating the next possible value for the updated element and adding it back to the priority queue.

After performing all B operations, determine the maximum value in the current state array.

The goal is to minimize the maximum element in the array after B operations.

 */
class CustomHeap {

    int val;
    int index;

    public CustomHeap(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
public class MinimumLargestElement {

    public int buildMinHeap(int[] array, int B) {

        PriorityQueue<CustomHeap> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        int[] stateArray = new int[array.length];

        for(int i = 0; i < array.length ; i++) {
            stateArray[i] = array[i];
        }

        int minimumLargest = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            // Heap is used to store next state so multiply by 2
            priorityQueue.add(new CustomHeap(array[i] * 2, i));
        }

        for(int i = 1; i <= B; i ++) {
            CustomHeap top = priorityQueue.poll();

            // this denotes current state of array
            stateArray[top.index] = top.val;

            top.val = top.val + array[top.index];

            // this step makes array to future / next step
            priorityQueue.offer(top);
        }

        for(int i = 0; i < array.length; i++) {
            minimumLargest = Math.max(stateArray[i], minimumLargest);
        }
        return minimumLargest;
    }



    public static void main(String[] args) {

        MinimumLargestElement minimumLargestElement = new MinimumLargestElement();
        System.out.println(minimumLargestElement.buildMinHeap(new int[] {1, 2, 3, 4}, 3));
        System.out.println(minimumLargestElement.buildMinHeap(new int[] {5, 1, 4, 2}, 5));

    }
}
