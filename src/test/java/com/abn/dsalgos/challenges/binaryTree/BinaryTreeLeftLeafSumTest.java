package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.annotations.Test;

public class BinaryTreeLeftLeafSumTest {

    private BinaryTreeLeftLeafSum<Integer>binaryTreeLeftLeafSum = new BinaryTreeLeftLeafSum<>();

    @Test
    public void test() throws Exception {
        binaryTreeLeftLeafSum.root = new MyTreeNode<>(10);
        binaryTreeLeftLeafSum.root.left = new MyTreeNode<>(5);
        binaryTreeLeftLeafSum.root.right = new MyTreeNode<>(15);
        binaryTreeLeftLeafSum.root.left.left = new MyTreeNode<>(10);
        binaryTreeLeftLeafSum.root.left.right = new MyTreeNode<>(12);
        binaryTreeLeftLeafSum.root.left.right.left = new MyTreeNode<>(6);
        binaryTreeLeftLeafSum.root.right.right = new MyTreeNode<>(8);
        binaryTreeLeftLeafSum.root.right.right.left = new MyTreeNode<>(5);
        binaryTreeLeftLeafSum.root.right.right.right = new MyTreeNode<>(10);

        System.out.println(binaryTreeLeftLeafSum.sumOfLeftLeafNode(binaryTreeLeftLeafSum.root));
    }
}
