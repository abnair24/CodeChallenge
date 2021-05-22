package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;

/*
    Find InOrder successor of a node in binary search tree

    HINT : What is Inorder Successor: Inorder successor of a node is the next node in
    the inorder traversal of the tree. For the last node in a tree,
    inorder successor will be NULL

    Case 1:  If right subtree of node is not NULL, then successor is the left most child in right subtree

    Case 2:  If right subtree of node is NULL, then succ is one of the ancestors
 */

public class InOrderSuccessor<T extends Comparable<T>> {

    MyBSTNode<T> root;

    public InOrderSuccessor() {
        root = null;
    }

    public void insertNode(MyBSTNode<T> node) {
        if(root == null) {
            root = node;
            return;
        }
        MyBSTNode<T> current = root;
        MyBSTNode<T> parent;
        while(current != null) {
            parent = current;

            if(node.data.compareTo(current.data)<0) {
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

    public MyBSTNode<T> getSuccessor(MyBSTNode<T> root, MyBSTNode<T> node) {

        MyBSTNode<T> successor = node.right;
        MyBSTNode<T> current = root;

        /*
        Case 1:
         */
        if(successor != null) {
            while(successor.left != null) {

                successor = successor.left;
            }
            return successor;
        }
        /*
         Case 2:
         */
        else {
            MyBSTNode<T> temp = null;

            while (current != null) {
                if (node.data.compareTo(current.data) == 0) {
                    break;
                } else if (node.data.compareTo(current.data) < 0) {
                    temp = current;
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return temp;
        }
    }
}
