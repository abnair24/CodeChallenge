package com.abn.dsalgos.utils;

public class MyTreeNode<T> {

    public MyTreeNode left, right;
    public T data;
    public boolean isVisited = false;

    public MyTreeNode(T data) {
        this.data = data;
        left = right = null;
        isVisited = false;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
