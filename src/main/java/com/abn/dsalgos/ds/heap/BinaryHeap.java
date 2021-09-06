package com.abn.dsalgos.ds.heap;

public class BinaryHeap<T extends Comparable<T>> {

    public T[] heap;
    public int length;
    public boolean min;

    public BinaryHeap(int len, boolean min) {
        heap = (T[]) new Comparable[len];
        length = 0;
        this.min = min;
    }

    public BinaryHeap(int len) {
        heap = (T[]) new Comparable[len];
        length = 0;
        this.min = true;
    }


    public void createHeap(T[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                insert(array[i]);
            }
        }
        display();
    }

    private void insert(T x) {
        if (length == heap.length) {
            System.out.println("reached limit");
        }

        int index = length++;
        heap[index] = x;
        heapifyUp(index);
    }

    /*
    Heapify up is used when we insert a new element to a heap. When inserting a new element, we add it at the
    bottom of the heap tree, and move up the tree while comparing to the current parent element and swapping if needed
     */

    private void heapifyUp(int index) {

        if (min) {
            while (index > 0 && heap[parentIndex(index)].compareTo(heap[index]) > 0) {
                swap(index, parentIndex(index));
                index = (index - 1) / 2;
            }
        } else {
            while (index > 0 && heap[parentIndex(index)].compareTo(heap[index]) < 0) {
                swap(index, parentIndex(index));
                index = (index - 1) / 2;
            }
        }
    }

    protected int parentIndex(int i) {
        return (i - 1) / 2;
    }

    public T extract() {
        if (length <= 0) {
            return null;
        }
        if (length == 1) {
            length--;
            return heap[0];
        }

        T root = heap[0];
        heap[0] = heap[length - 1];
        heap[length - 1] = null;
        length--;

        if (min) {
            minHeapifyDown(0);
        } else {
            maxHeapifyDown(0);
        }
        display();

        return root;
    }

    /*
    Heapify down is used when we remove the top element from a heap. Removal of an element is done by
    swapping the top element with the last element at the bottom of the tree,
    removing the last element, and then heapfying the new top element down to maintain the heap property
     */
    private void minHeapifyDown(int index) {
        int lIndex = 2 * index + 1;
        int rIndex = 2 * index + 2;

        int small = index;

        if (lIndex < length && heap[lIndex].compareTo(heap[index]) < 0) {
            small = lIndex;
        }
        if (rIndex < length && heap[rIndex].compareTo(heap[small]) < 0) {
            small = rIndex;
        }

        if (small != index) {
            swap(index, small);
            minHeapifyDown(small);
        }
    }

    private void maxHeapifyDown(int index) {
        int lIndex = 2 * index + 1;
        int rIndex = 2 * index + 2;

        int large = index;

        if (lIndex < length && heap[lIndex].compareTo(heap[index]) > 0) {
            large = lIndex;
        }
        if (rIndex < length && heap[rIndex].compareTo(heap[large]) > 0) {
            large = rIndex;
        }

        if (large != index) {
            swap(index, large);
            maxHeapifyDown(large);
        }
    }

    private void swap(int cIndex, int pIndex) {
        T temp = heap[cIndex];
        heap[cIndex] = heap[pIndex];
        heap[pIndex] = temp;
    }


    private void display() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }
}
