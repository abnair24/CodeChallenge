package com.abn.scalar.dsa.day44Lab;

import java.util.HashMap;
import java.util.Map;

/*
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.

Approach:

1.Create a HashMap to store the indices of values in the inorder traversal for O(1) lookup
2.The last element of the postorder traversal is always the root of the current subtree
3. Use the root value to split the inorder traversal into left and right subtrees
4. Recursively construct the left and right subtrees
 */
public class BTFromInorderPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create a map to quickly locate values in the inorder traversal

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> inorderMap) {
        // Base case: if there are no elements to construct the tree
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element in postorder is the root of the current subtree
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find the position of the root in inorder traversal
        int rootIndex = inorderMap.get(rootVal);

        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSubtreeSize - 1,
                inorderMap);

        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSubtreeSize, postEnd - 1,
                inorderMap);

        return root;
    }
}
