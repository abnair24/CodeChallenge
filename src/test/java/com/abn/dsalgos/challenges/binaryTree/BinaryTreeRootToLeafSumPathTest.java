package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeRootToLeafSumPathTest {

    BinaryTreeRootToLeafSumPath<Integer> binaryTree = new BinaryTreeRootToLeafSumPath<>();

    @Test
    public void test() throws Exception{
        MyTreeNode<Integer> node1 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(8  );
        MyTreeNode<Integer> node4 = new MyTreeNode<>(11);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(13);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node9 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node10 = new MyTreeNode<>(5);

        binaryTree.root = node1;
        binaryTree.root.left = node2;
        binaryTree.root.right = node3;
        binaryTree.root.left.left = node4;
        binaryTree.root.left.left.left = node5;
        binaryTree.root.left.left.right = node6;
        binaryTree.root.right.left = node7;
        binaryTree.root.right.right = node8;
        binaryTree.root.right.right.right = node9;
        binaryTree.root.right.right.left = node10;

        binaryTree.getPath(node1,22);
    }
}
