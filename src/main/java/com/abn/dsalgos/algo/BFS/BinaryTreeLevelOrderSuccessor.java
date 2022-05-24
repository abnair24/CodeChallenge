package com.abn.dsalgos.algo.BFS;

/*
        Given a binary tree and a node, find the level order successor of the given node in the tree.
        The level order successor is the node that appears right after the given node in the level order traversal.

                1
             2      3
          4     5

Level order successor of 3 : 4
*/

import com.abn.dsalgos.utils.TreeNode;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderSuccessor {

    public TreeNode levelOrderSuccessor(TreeNode root, int target) {

        if(root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(queue.size() > 0) {

            TreeNode current = queue.remove();

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }

            if(current.val == target) {
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderSuccessor levelOrderSuccessor = new BinaryTreeLevelOrderSuccessor();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Assert.assertEquals(levelOrderSuccessor.levelOrderSuccessor(root, 4).val, 5);
    }
}
