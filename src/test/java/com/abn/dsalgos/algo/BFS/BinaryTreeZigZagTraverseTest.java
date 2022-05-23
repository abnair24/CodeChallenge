package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.algo.BFS.BinaryTreeZigZagTraverse;
import com.abn.dsalgos.utils.TreeNode;
import org.testng.annotations.Test;

public class BinaryTreeZigZagTraverseTest {

    BinaryTreeZigZagTraverse tree;

    @Test
    public void test() throws Exception {
        tree = new BinaryTreeZigZagTraverse();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        tree.zigZag(root);
    }
}
