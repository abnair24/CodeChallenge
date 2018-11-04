package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;

/*
Validate BST: Implement a function to check if a binary tree is a binary search tree.

 */
public class BinaryTreeIsBST<T extends Comparable<T>> {

    public MyBSTNode<T> root;

    public BinaryTreeIsBST() {
        root = null;
    }


    public boolean isBST(MyBSTNode<T> root, T min, T max) {


        if (root == null) {
            return true;
        } else {

            if (root.data.compareTo(max) > 0 || root.data.compareTo(min) < 0) {
                return false;
            }

            System.out.println("Root : " + root.data + " min: " + min + " max: " + max);

            boolean isLeftTreeBST = isBST(root.left, min, root.data);
            boolean isRightTreeBST = isBST(root.right, root.data, max);

            return isLeftTreeBST && isRightTreeBST;
        }
    }
}
