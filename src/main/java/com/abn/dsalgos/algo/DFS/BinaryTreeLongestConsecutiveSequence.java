package com.abn.dsalgos.algo.DFS;


import com.abn.dsalgos.utils.TreeNode;
import org.testng.Assert;

/*
Given the root of a binary tree, return the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The longest consecutive path needs to be from parent to child (cannot be the reverse).


                                1
                                    3
                                2       4
                                            5

   Longest sequence length = 3 (3->4->5)
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int maxLength = 0;

    public int longestSequence(TreeNode root) {

        longestSequence(root, null, 0);
        return maxLength;
    }

    private void longestSequence(TreeNode root, TreeNode parent, int length) {

        if(root == null) {
            return ;
        }

        if(parent != null && root.val == parent.val + 1) {
            length += 1;
        } else {
            length = 1;
        }

        maxLength = Math.max(maxLength, length);

        longestSequence(root.left, root, length);
        longestSequence(root.right, root, length);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        BinaryTreeLongestConsecutiveSequence binaryTreeLongestConsecutiveSequence = new BinaryTreeLongestConsecutiveSequence();

        Assert.assertEquals(binaryTreeLongestConsecutiveSequence.longestSequence(root), 3);
    }

}
