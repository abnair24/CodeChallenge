package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeIsBalancedRecursiveTest {

    BinaryTreeIsBalancedRecursive binaryTreeIsBalancedRecursive = new BinaryTreeIsBalancedRecursive();

    @Test
    public void test1() throws Exception {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.right.right = new MyTreeNode<>(6);
        root.right.right.right = new MyTreeNode<>(7);

        Assert.assertFalse(binaryTreeIsBalancedRecursive.isBalanced(root));
    }

    @Test
    public void test7() {

        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.right.left = new MyTreeNode<>(6);
        root.left.left.left = new MyTreeNode<>(8);

        Assert.assertTrue(binaryTreeIsBalancedRecursive.isBalanced(root));

    }
}
