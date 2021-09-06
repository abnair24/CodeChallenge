package com.abn.dsalgos.algo.DFS;


import com.abn.dsalgos.utils.MyBSTNode;

/*
Given a BST and node to delete,

1. If the target node has no child, we can simply remove the node.
2. If the target node has one child, we can use its child to replace itself.
3. If the target node has two children, replace the node with its in-order successor or predecessor node and delete that node.
 */
public class BSTDeleteNode {

    //WIP
    public MyBSTNode<Integer> deleteNode(MyBSTNode<Integer> root, int val) {

        if (root == null) {
            return root;
        }

        if (root.data == val) {

            //If there is only one child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            /*
            if both child present,
                - find inorder successor.
                - replace the root value and successor value
                - delete the node.
             */

            MyBSTNode<Integer> successor = findSuccessor(root, val);
            root.data = successor.data;
            root.right = deleteNode(root.right, val);
        }

        if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            root.left = deleteNode(root.left, val);
        }

        return root;
    }

    private MyBSTNode<Integer> findSuccessor(MyBSTNode<Integer> root, int value) {

        if (root == null) {
            return null;
        }
        MyBSTNode<Integer> successor = null;
        while (root != null) {
            if (root.data <= value) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return root;
    }
}
