package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.algo.BFS.BinaryTreeLevelOrderTraverse;
import com.abn.dsalgos.utils.TreeNode;
import org.testng.annotations.Test;

public class BinaryTreeLevelOrderTraverseTest {

    BinaryTreeLevelOrderTraverse binaryTreeLOT;

    @Test
    public void test() throws Exception {
        binaryTreeLOT = new BinaryTreeLevelOrderTraverse();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        binaryTreeLOT.levelOrder(root);
    }
}
