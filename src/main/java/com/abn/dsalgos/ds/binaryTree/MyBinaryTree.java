package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

public class MyBinaryTree<T> {

    MyTreeNode root;

    public MyBinaryTree() {
        root = null;
    }

    public void inOrder(MyTreeNode node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
}