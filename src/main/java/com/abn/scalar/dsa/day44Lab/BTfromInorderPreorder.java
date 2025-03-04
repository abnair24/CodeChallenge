package com.abn.scalar.dsa.day44Lab;

import java.util.HashMap;
import java.util.Map;

/*

Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.

1. Create a HashMap to store the indices of values in the inorder traversal for O(1) lookup
2. The first element of the preorder traversal is always the root of the current subtree
3. Use the root value to split the inorder traversal into left and right subtrees
4. Recursively construct the left and right subtrees
 */
public class BTfromInorderPreorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Create a map to quickly locate values in the inorder traversal
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inorderMap) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root of the current subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the position of the root in inorder traversal
        int rootIndex = inorderMap.get(rootVal);

        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, rootIndex - 1,
                inorderMap);

        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd,
                inorderMap);

        return root;
    }
}
