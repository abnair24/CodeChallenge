package com.abn.dsalgos.ds.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;

public class MyBinarySearchTree<T extends Comparable<T>> {

    MyBSTNode<T> root;

    public MyBinarySearchTree() {
        root = null;
    }


    public void insertNode(MyBSTNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }

        MyBSTNode<T> current = root;
        MyBSTNode<T> parent = null;

        while(current != null) {
            parent = current;

            if(node.data.compareTo(current.data) < 0) {

                current = current.left;
                if(current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public boolean search(MyBSTNode<T> node) {
        MyBSTNode<T> temp = root;

        while(temp!=null){
            if(node.data.compareTo(temp.data) == 0){
                return true;
            }
            if(node.data.compareTo(temp.data) > 0) {
                temp = temp.right;
            }
            if(node.data.compareTo(temp.data) < 0) {
                temp = temp.left;
            }
        }
        return false;
    }

    public void display(MyBSTNode<T> node) {
        if(node != null) {
            display(node.left);
            System.out.println(node.data);
            display(node.right);
        }
    }

}
