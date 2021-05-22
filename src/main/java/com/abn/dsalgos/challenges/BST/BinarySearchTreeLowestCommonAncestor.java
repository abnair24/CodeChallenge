package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;


public class BinarySearchTreeLowestCommonAncestor<T extends Comparable<T>> {

    MyBSTNode<T> root;

    public BinarySearchTreeLowestCommonAncestor() {
        root = null;
    }

    public void insertNode(MyBSTNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }

        MyBSTNode<T> current = root;
        MyBSTNode<T> parent;

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

    public T lowestCommonAncestor(MyBSTNode<T> root,MyBSTNode<T> node1, MyBSTNode<T> node2){

        MyBSTNode<T> temp = root;

        /*
          Case 1: If root is null or both the nodes passed are same
         */
        if(root == null || node1.data.compareTo(node2.data) == 0) {
            return null;
        }

        /*
         Case 2: If either of the node equals root, return root;
         */
        if(node1.data.compareTo(root.data) == 0 || node2.data.compareTo(root.data) == 0) {
            return root.data;
        }

        /*
         Case 3: If one of the nodes is greater than the root and another is less than the root,
          then return root;
         */
        if( (node1.data.compareTo(root.data) > 0 && node2.data.compareTo(root.data) < 0) ||
                (node2.data.compareTo(root.data) > 0 && node1.data.compareTo(root.data) < 0 )) {
            return root.data;
        }

        /*
        If both nodes are less than root, iterate through left tree and find the max of 2
        If both nodes are greater than root, iterate through right tree and find the max of 2
         */
        else  {
            while(temp != null) {
                if(temp.data.compareTo(node1.data) > 0 && temp.data.compareTo(node2.data) > 0) {
                    temp = temp.left;
                }
                else if(temp.data.compareTo(node1.data) <0 && temp.data.compareTo(node2.data) < 0) {
                    temp = temp.right;
                }
                else {
                    return temp.data;
                }
            }
        }
        return temp.data;
    }
}
