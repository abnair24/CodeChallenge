package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.utils.TreeNode;

/*
given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees
are overlapped while the others are not. You need to merge the two trees into a new
binary tree. The merge rule is that if two nodes overlap, then sum node values up as
the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.


            1                      2                    =           3
        3       2              1        3                       4       5
     5                             4        7                5     4        7
 */
public class MergeBinaryTree {

    public TreeNode merge(TreeNode root1, TreeNode root2) {

        if(root1 == null) {
            return root2;
        }

        if(root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;

        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);

        return root1;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        TreeNode root = mergeBinaryTree.merge(root1, root2);
        System.out.println(root.val);
    }
}
