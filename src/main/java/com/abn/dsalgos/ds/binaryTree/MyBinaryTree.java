package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;

public class MyBinaryTree<T> {

    MyTreeNode root;

    public MyBinaryTree() {
        root = null;
    }

    public void inOrder(MyTreeNode<T> node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void preOrder(MyTreeNode<T> node) {
        if(node == null) {
            return;
        }

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(MyTreeNode<T> node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
}