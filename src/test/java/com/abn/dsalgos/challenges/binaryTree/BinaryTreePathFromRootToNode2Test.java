package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreePathFromRootToNode2Test {

    BinaryTreePathFromRootToNode2<Integer> binaryTree = new BinaryTreePathFromRootToNode2<>();

    @Test
    public void test() throws Exception {

        MyTreeNode<Integer> node1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(8);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(7);

        binaryTree.root = node1;
        binaryTree.root.left = node2;
        binaryTree.root.right = node3;
        binaryTree.root.left.left = node4;
        binaryTree.root.left.right = node5;
        binaryTree.root.right.left = node6;
        binaryTree.root.right.left.right = node7;
        binaryTree.root.right.right = node8;

        binaryTree.getPath(node1, node6);
        binaryTree.getPath(node1, node5);
    }
}
