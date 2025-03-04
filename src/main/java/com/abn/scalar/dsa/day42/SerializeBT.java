package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:

 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2:

 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 */
public class SerializeBT {

    public ArrayList<Integer> solve(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.val);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if(current.left != null) {
                queue.add(current.left);
                list.add(current.left.val);
            }

            if(current.left == null) {
                list.add(-1);
            }

            if(current.right != null) {
                queue.add(current.right);
                list.add(current.right.val);
            }

            if(current.right == null) {
                list.add(-1);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        SerializeBT serializeBT = new SerializeBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        serializeBT.solve(root);
    }
}
