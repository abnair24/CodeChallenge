package com.abn.dsalgos.ds.queue;

import java.util.Arrays;

public class QArrays<T> {
    private static final int MAX_SIZE = 10;
    private int size;
    private Object[] element;
    private int front;
    private int rear;


    public QArrays() {
        element = new Object[MAX_SIZE];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return (element.length == 0);
    }

    public void enqueue(T t) {
        if (size == element.length) {
            int newSize = element.length * 2;
            element = Arrays.copyOf(element, newSize);
        }
        element[size++] = t;
    }

    public T dequeue() {
        T t = (T) element[front];
        front++;
        if (front == element.length - 1) {
            front = 0;
        }
        size--;
        return t;
    }
}
