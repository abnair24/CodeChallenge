package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinaryTreeIsBalancedTest {

    BinaryTreeIsBalanced binaryTreeIsBalanced;

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod()
            throws Exception {
        binaryTreeIsBalanced = new BinaryTreeIsBalanced();
    }

    @Test
    public void test()
            throws Exception {

        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.left.left.left = new MyTreeNode<>(8);
        root.right.right = new MyTreeNode<>(7);
        root.right.left = new MyTreeNode<>(6);

        Assert.assertTrue(binaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    public void test2()
            throws Exception {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.left.left = new MyTreeNode<>(3);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    public void test3()
            throws Exception {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.left.left.left = new MyTreeNode<>(6);
        root.left.left.right = new MyTreeNode<>(7);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    public void test4()
            throws Exception {

        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.right = new MyTreeNode<>(2);
        root.right.left = new MyTreeNode<>(3);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    public void test5()
            throws Exception {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.right.right = new MyTreeNode<>(6);
        root.right.right.right = new MyTreeNode<>(7);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    public void test6() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);

        Assert.assertTrue(binaryTreeIsBalanced.isBalanced(root));
    }

    // WIP : Test fails.
    @Test
    public void test7() {

        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.left = new MyTreeNode<>(2);
        root.right = new MyTreeNode<>(3);
        root.left.left = new MyTreeNode<>(4);
        root.left.right = new MyTreeNode<>(5);
        root.right.left = new MyTreeNode<>(6);
        root.left.left.left = new MyTreeNode<>(8);

        Assert.assertTrue(binaryTreeIsBalanced.isBalanced(root));

    }
}
