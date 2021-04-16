package com.abn.dsalgos.challenges.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
}

public class BinaryTreeLevelOrderConnect {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        connectLevels(root);
    }

    public static TreeNode connectLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode previous = null;
        int nodeCount = 0;

        if(root == null) {
            return null;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            previous = null;
            nodeCount = queue.size();

            while(nodeCount > 0) {

                TreeNode current = queue.remove();

                if(previous != null) {
                    previous.next = current;
                }
                previous = current;

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }

                nodeCount --;
            }
        }
        return root;
    }
}
