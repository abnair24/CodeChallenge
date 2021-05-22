package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreePathFromRootToNodeTest {

    BinaryTreePathFromRootToNode<Integer> binaryTreePathFromRootToNode = new BinaryTreePathFromRootToNode<>();

    @Test
    public void test() throws Exception {
        binaryTreePathFromRootToNode.root = new MyTreeNode<>(1);
        binaryTreePathFromRootToNode.root.left = new MyTreeNode<>(2);
        binaryTreePathFromRootToNode.root.right = new MyTreeNode<>(3);
        binaryTreePathFromRootToNode.root.left.left = new MyTreeNode<>(4);
        binaryTreePathFromRootToNode.root.left.right = new MyTreeNode<>(5);
        binaryTreePathFromRootToNode.root.right.left = new MyTreeNode<>(6);
        binaryTreePathFromRootToNode.root.right.left.right = new MyTreeNode<>(8);
        binaryTreePathFromRootToNode.root.right.right = new MyTreeNode<>(7);

        binaryTreePathFromRootToNode.getPath(binaryTreePathFromRootToNode.root, 6);
    }
}
