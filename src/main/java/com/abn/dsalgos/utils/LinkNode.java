package com.abn.dsalgos.utils;

/**
 * Created by aswathyn on 14/02/17.
 */
public class LinkNode<T> {

    public LinkNode next;
    public T data;

    public LinkNode(T data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.println("{ " + data.toString());
    }
}
