package com.abn.dsalgos.ds.heap;

public class HeapMin {

    public int[] heap;
    public int length;

    public HeapMin(int len) {
        heap = new int[len];
        length = 0;
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
        int parentIndex = (index-1)/2;

        while(index>0 && heap[parentIndex] > heap[index]) {
            swap(index,parentIndex);
            parentIndex = (parentIndex-1)/2;
        }
    }

    public int extractMin() {
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
        heapifyDown(0);
        display();

        return root;
    }

    private void heapifyDown(int index) {
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
            heapifyDown(small);
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
