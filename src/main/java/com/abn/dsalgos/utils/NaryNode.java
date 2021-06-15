package com.abn.dsalgos.utils;

import java.util.List;

public class NaryNode {

    public int data;
    public List<NaryNode> children;

    public NaryNode() { }

    public NaryNode(int data) {
        this.data = data;
    }

    public NaryNode(int data, List<NaryNode> children) {
        this.data = data;
        this.children = children;
    }
}
