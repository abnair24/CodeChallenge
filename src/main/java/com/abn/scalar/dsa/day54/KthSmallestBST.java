package com.abn.scalar.dsa.day54;

import com.abn.dsalgos.utils.TreeNode;

import java.util.Stack;

/*
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Input 1:


            2
          /   \
         1    3
B = 2

Output 1:

 2

Input 2:


            3
           /
          2
         /
        1
B = 1


Output 2:

 1

 */
public class KthSmallestBST {

    /*
      Traverse tree in-order. While popping out from stack, decrement the k value.
    Return node value when k becomes zero
     */

    public int kthsmallest(TreeNode A, int B) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = A;

        while (true) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }

            if (stack.isEmpty()) {
                return -1;
            }
            temp = stack.pop();
            B--;

            if (B == 0) {
                return temp.val;
            }
            temp = temp.right;
        }
    }

//    int count = 0;
//    int ans = 0;
//    public void inorder(TreeNode root, int k) {
//
//        if(root == null) {
//            return;
//        }
//        inorder(root.left, k);
//        count++;
//
//        if(count == k) {
//            ans = root.val;
//            return;
//        }
//
//        inorder(root.right, k);
//    }

//    public int smallestOptimal(TreeNode root, int k) {
//
//        inorder(root, k);
//        return ans;
//    }

    public static void main(String[] args) {

        KthSmallestBST kthSmallestBST = new KthSmallestBST();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(25);

        System.out.println(kthSmallestBST.kthsmallest(root, 6));
    }
}
