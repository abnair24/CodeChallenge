package com.abn.dsalgos.utils;

/**
 * Created by aswathyn on 17/02/17.
 */
public class DoubleLinkNode<T> {

    public DoubleLinkNode next;
    public DoubleLinkNode previous;
    public T data;

    public DoubleLinkNode(T data) {
        this.data = data;
        next = null;
        previous = null;
    }
}
