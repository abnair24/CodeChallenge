package com.abn.dsalgos.utils;

public class MyBTBSTNode<T extends Comparable<T>> {

    public MyBTBSTNode<T> left, right;
    public T data;
    public Integer min;
    public Integer max;

    public MyBTBSTNode(T data) {
        this.data = data;
        left = right = null;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
    }
}
