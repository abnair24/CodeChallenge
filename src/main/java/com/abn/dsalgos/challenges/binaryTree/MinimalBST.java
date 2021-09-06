package com.abn.dsalgos.challenges.binaryTree;

/*
    Given a sorted (increasing order) array with unique integer elements,
    write an algorithm to create a binary search tree with minimal height.
 */


/*
    1. Insert middle element as root
    2. Insert left side of middle element in array as left side of tree
    3. Insert right side of middle element in array as right side of tree
    4. Recursion
 */

import com.abn.dsalgos.utils.MyTreeNode;

public class MinimalBST {

    public MyTreeNode<Integer> arrayToBST(int[] array) {

        return binarySearchTree(array, 0, array.length - 1);
    }

    private MyTreeNode<Integer> binarySearchTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        MyTreeNode<Integer> node = new MyTreeNode<>(arr[mid]);

        node.left = binarySearchTree(arr, start, mid - 1);
        node.right = binarySearchTree(arr, mid + 1, end);
        return node;
    }

    public void preOrder(MyTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);

    }
}
