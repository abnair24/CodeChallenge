package com.abn.dsalgos.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MyNarrayTreeNode<T> {

    public T data;
    public List<MyNarrayTreeNode<T>> children;
    public MyNarrayTreeNode<T> parent;

    public MyNarrayTreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }


}
