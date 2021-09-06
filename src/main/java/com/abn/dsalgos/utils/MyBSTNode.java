package com.abn.dsalgos.utils;

public class MyBSTNode<T extends Comparable<T>> {

    public MyBSTNode left, right;
    public T data;

    public MyBSTNode(T data) {
        this.data = data;
        left = right = null;
    }
}
