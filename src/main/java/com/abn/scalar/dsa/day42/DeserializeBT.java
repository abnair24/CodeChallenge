package com.abn.scalar.dsa.day42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Example Input

Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output

Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


 */
public class DeserializeBT {

    public TreeNode deserialize(ArrayList<Integer> arrayList) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arrayList.get(0));

        int index = 1;

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int left = arrayList.get(index);
            int right = arrayList.get(index + 1);

            if(left != -1) {
                current.left = new TreeNode(left);
                queue.add(current.left);
            }

            if(right != -1) {
                current.right = new TreeNode(right);
                queue.add(current.right);
            }

            index = index + 2;
        }

        return root;
    }
}
