package com.abn.dsalgos.ds.heap;

public class BinaryHeap {

    public int[] heap;
    public int length;
    public boolean min;

    public BinaryHeap(int len, boolean min) {
        heap = new int[len];
        length = 0;
        this.min = min;
    }

    public BinaryHeap(int len) {
        heap = new int[len];
        length = 0;
        this.min = true;
    }


    public void createHeap(int[] array) {
        if(array.length > 0) {
            for (int i =0; i < array.length; i++) {
                insert(array[i]);
            }
        }
        display();
    }

    private void insert(int x) {
        if(length == heap.length) {
            System.out.println("reached limit");
        }

        int index = length++;
        heap[index] = x;
        heapifyUp(index);
    }

    private void heapifyUp(int index) {

        if(min) {
            while(index>0 && heap[parentIndex(index)] > heap[index]) {
                swap(index,parentIndex(index));
                index = (index-1)/2;
            }
        } else {
            while(index>0 && heap[parentIndex(index)] < heap[index]) {
                swap(index, parentIndex(index));
                index = (index - 1) / 2;
            }
        }
    }

    protected int parentIndex(int i) {
         return (i-1)/2;
    }

    public int extract() {
        if(length<=0) {
            return 0;
        } if(length == 1) {
            length --;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[length -1];
        heap[length-1] = 0;
        length --;

        if(min) {
            minHeapifyDown(0);
        } else{
            maxHeapifyDown(0);
        }
        display();

        return root;
    }

    private void minHeapifyDown(int index) {
        int lIndex = 2*index +1;
        int rIndex = 2*index +2;

        int small = index;

        if(lIndex < length && heap[lIndex] < heap[index]) {
            small = lIndex;
        }
        if(rIndex < length && heap[rIndex] < heap[small]) {
            small = rIndex;
        }

        if(small != index) {
            swap(index,small);
            minHeapifyDown(small);
        }
    }

    private void maxHeapifyDown(int index) {
        int lIndex = 2*index +1;
        int rIndex = 2*index +2;

        int large = index;

        if(lIndex < length && heap[lIndex] > heap[index]) {
            large = lIndex;
        }
        if(rIndex < length && heap[rIndex] > heap[large]) {
            large = rIndex;
        }

        if(large != index) {
            swap(index,large);
            maxHeapifyDown(large);
        }
    }

    private void swap(int cIndex, int pIndex) {
        int temp = heap[cIndex];
        heap[cIndex] = heap[pIndex];
        heap[pIndex] = temp;
    }


    private void display() {
        for(int i =0; i<heap.length;i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println("");
    }
}
