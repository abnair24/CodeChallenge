package com.abn.dsalgos.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * Created by aswathyn on 14/02/17.
 */
public class StackArrays<T> {
    private int size ;
    private static final int MAX_SIZE=10;
    private Object[] element ;
    private int top;


    public StackArrays() {
        element= new Object[MAX_SIZE];
        size=0;
        top =-1;

    }
    public void push(T t) {
        if(size == element.length ) {
            int newSize = element.length *2;
            element = Arrays.copyOf(element, newSize);
        }
        element[size++] =t;
        top = size;

    }

    public T pop() {
        if(isEmpty()) {
            throw  new EmptyStackException();
        } else {
            T t = (T) element[--size];
            return t;
        }
    }

    public boolean isEmpty() {
        return (size ==0);
    }

    public T peek() {
        if(isEmpty()) {
            throw  new EmptyStackException();
        } else {
            top = getSize();
            T t = (T) element[--top];
            return t;
        }
    }

    public int getSize() {
        return size;
    }

}
