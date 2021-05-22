package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeFullNodesTest {

    BinaryTreeFullNodes<Integer> binaryTreeFullNodes = new BinaryTreeFullNodes<>();

    @Test
    public void test() throws Exception {
        binaryTreeFullNodes.root = new MyTreeNode<>(1);
        binaryTreeFullNodes.root.left = new MyTreeNode<>(2);
        binaryTreeFullNodes.root.right = new MyTreeNode<>(3);
        binaryTreeFullNodes.root.left.left = new MyTreeNode<>(4);
        binaryTreeFullNodes.root.left.right = new MyTreeNode<>(5);
        binaryTreeFullNodes.root.left.right.left = new MyTreeNode<>(7);
        binaryTreeFullNodes.root.left.left.left = new MyTreeNode<>(6);
        binaryTreeFullNodes.root.right.right = new MyTreeNode<>(8);
        binaryTreeFullNodes.root.right.right.left = new MyTreeNode<>(9);

        binaryTreeFullNodes.findFullNodes(binaryTreeFullNodes.root);
    }
}
