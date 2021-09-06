package com.abn.dsalgos.algo.heap;

import java.util.PriorityQueue;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:

    1. insertNum(int num): stores the number in the class
    2. findMedian(): returns the median of all numbers inserted in the class

If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5
 */
public class MedianOfStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));

    /*
    Values on left side of median is always less and forms a max heap.
    Values on right side of median is greater and forms a min heap

    Always insert of maxheap first.
    If maxHeap - minHeap size > 1, rearrange.

    If odd number of data is present, then median is maxheap top value
    If even number of data is present, then median is 2 heaps peak's sum /2.0
     */
    public void insert(int num) {

        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {

        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
