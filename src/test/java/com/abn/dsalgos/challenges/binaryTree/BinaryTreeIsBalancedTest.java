package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinaryTreeIsBalancedTest {

    BinaryTreeIsBalanced<Integer> binaryTreeIsBalanced;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
       binaryTreeIsBalanced = new BinaryTreeIsBalanced<>();
    }

    @Test
    public void test() throws Exception{
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.left = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.right = new MyTreeNode<>(3);
        binaryTreeIsBalanced.root.left.left = new MyTreeNode<>(4);
        binaryTreeIsBalanced.root.left.right = new MyTreeNode<>(5);
        binaryTreeIsBalanced.root.left.left.left = new MyTreeNode<>(8);
        binaryTreeIsBalanced.root.right.right = new MyTreeNode<>(7);
        binaryTreeIsBalanced.root.right.left = new MyTreeNode<>(6);

        Assert.assertTrue(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }

    @Test
    public void test2() throws Exception {
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.left = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.left.left = new MyTreeNode<>(3);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }

    @Test
    public void test3() throws Exception {
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.left = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.right = new MyTreeNode<>(3);
        binaryTreeIsBalanced.root.left.left = new MyTreeNode<>(4);
        binaryTreeIsBalanced.root.left.right = new MyTreeNode<>(5);
        binaryTreeIsBalanced.root.left.left.left = new MyTreeNode<>(6);
        binaryTreeIsBalanced.root.left.left.right = new MyTreeNode<>(7);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }

    @Test
    public void test4() throws Exception {
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.right = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.right.left = new MyTreeNode<>(3);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }

    @Test
    public void test5() throws Exception {
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.left = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.right = new MyTreeNode<>(3);
        binaryTreeIsBalanced.root.left.left = new MyTreeNode<>(4);
        binaryTreeIsBalanced.root.left.right = new MyTreeNode<>(5);
        binaryTreeIsBalanced.root.right.right = new MyTreeNode<>(6);
        binaryTreeIsBalanced.root.right.right.right = new MyTreeNode<>(7);

        Assert.assertFalse(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }

    @Test
    public void test6() throws Exception {
        binaryTreeIsBalanced.root = new MyTreeNode<>(1);
        binaryTreeIsBalanced.root.left = new MyTreeNode<>(2);
        binaryTreeIsBalanced.root.right = new MyTreeNode<>(3);
        binaryTreeIsBalanced.root.left.left = new MyTreeNode<>(4);

        Assert.assertTrue(binaryTreeIsBalanced.isBalanced(binaryTreeIsBalanced.root));
    }
}
