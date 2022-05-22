package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.TreeNode;
import org.testng.annotations.Test;

public class DiameterOfBinaryTreeTest {
    @Test
    public void test() throws Exception {

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        diameterOfBinaryTree.root = node1;
        diameterOfBinaryTree.root.left = node2;
        diameterOfBinaryTree.root.left.left = node3;
        diameterOfBinaryTree.root.left.left.right = node8;
        diameterOfBinaryTree.root.left.left.right.left = node9;
        diameterOfBinaryTree.root.left.right = node5;
        diameterOfBinaryTree.root.left.right.right = node6;
        diameterOfBinaryTree.root.left.right.right.left = node7;
        diameterOfBinaryTree.root.right = node4;

        diameterOfBinaryTree.diameterOfBinaryTree(node1);
    }
}
