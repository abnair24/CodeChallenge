package com.abn.dsalgos.utils;

public class TreeNodeConnect {
    public int val;
    public TreeNodeConnect left;
    public TreeNodeConnect right;
    public TreeNodeConnect next;

    public TreeNodeConnect(int x) {
        val = x;
        left = right = next = null;
    }
}
