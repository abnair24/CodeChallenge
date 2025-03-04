package com.abn.scalar.dsa.day55;

import com.abn.dsalgos.utils.TreeNode;

/*
Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.

input 1:

     1
   /   \
  2     3

Output 1:

     1
   /   \
  3     2

Input 2:

     1
   /   \
  2     3
 / \   / \
4   5 6   7


Output 2:

     1
   /   \
  3     2
 / \   / \
7   6 5   4

 */
public class InvertBT {

    public TreeNode invert(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode invertedLeftNode = invert(root.left);
        TreeNode invertedRightNode = invert(root.right);

        root.left = invertedRightNode;
        root.right = invertedLeftNode;
        return root;
    }

    public static void main(String[] args) {

        InvertBT invertBT = new InvertBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        invertBT.invert(root);
    }

}
