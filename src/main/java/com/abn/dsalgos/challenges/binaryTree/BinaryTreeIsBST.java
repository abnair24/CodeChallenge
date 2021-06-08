package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyBSTNode;

/*
Validate BST: Implement a function to check if a binary tree is a binary search tree.

 */
public class BinaryTreeIsBST {

    public MyBSTNode<Integer> root;

    public BinaryTreeIsBST() {
        root = null;
    }

    public boolean isValidBST(MyBSTNode<Integer> root, Integer min, Integer max) {


        if (root == null) {
            return true;
        }
        if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
            return false;
        }
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }


    public boolean isBST(MyBSTNode<Integer> node) {

        // Integer.MIN_VALUE and Integer.MAX_VALUE is not used for max and min values
        // as if single node with MAX_VALUE is present,
        // returns false instead of true. Modified code and added test.

        return isValidBST(node, null, null);
    }
}
