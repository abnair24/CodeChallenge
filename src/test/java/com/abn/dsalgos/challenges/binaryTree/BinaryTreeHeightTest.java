package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeHeightTest {

    private BinaryTreeHeight<Integer> binaryTreeHeight = new BinaryTreeHeight<>();

    @Test
    public void test() throws Exception {
        binaryTreeHeight.root = new MyTreeNode<>(1);
        binaryTreeHeight.root.left = new MyTreeNode<>(2);
        binaryTreeHeight.root.right = new MyTreeNode<>(3);
        binaryTreeHeight.root.left.left = new MyTreeNode<>(4);
        binaryTreeHeight.root.left.right = new MyTreeNode<>(5);
        binaryTreeHeight.root.left.right.left = new MyTreeNode<>(6);
        Assert.assertEquals(binaryTreeHeight.height(binaryTreeHeight.root),4);
    }

    @Test
    public void test1() throws Exception {
        binaryTreeHeight.root = new MyTreeNode<>(1);
        binaryTreeHeight.root.left = new MyTreeNode<>(2);
        binaryTreeHeight.root.right = new MyTreeNode<>(3);
        binaryTreeHeight.root.left.left = new MyTreeNode<>(4);
        binaryTreeHeight.root.left.right = new MyTreeNode<>(5);
        binaryTreeHeight.root.right.right = new MyTreeNode<>(6);
        binaryTreeHeight.root.right.right.right = new MyTreeNode<>(7);
        binaryTreeHeight.root.right.right.right.left = new MyTreeNode<>(8);
        binaryTreeHeight.root.right.right.right.right = new MyTreeNode<>(9);
        binaryTreeHeight.root.right.right.right.left.left = new MyTreeNode<>(10);
        binaryTreeHeight.root.right.right.right.left.left.right = new MyTreeNode<>(11);
        binaryTreeHeight.root.right.right.right.left.left.right.right = new MyTreeNode<>(12);
        binaryTreeHeight.root.right.right.right.left.left.right.right.left = new MyTreeNode<>(13);
        Assert.assertEquals(binaryTreeHeight.height(binaryTreeHeight.root),9);
    }

    @Test
    public void testRecursive() throws Exception {
        binaryTreeHeight.root = new MyTreeNode<>(1);
        binaryTreeHeight.root.left = new MyTreeNode<>(2);
        binaryTreeHeight.root.right = new MyTreeNode<>(3);
        binaryTreeHeight.root.left.left = new MyTreeNode<>(4);
        binaryTreeHeight.root.left.right = new MyTreeNode<>(5);
        binaryTreeHeight.root.left.right.left = new MyTreeNode<>(6);
        Assert.assertEquals(binaryTreeHeight.heightRecursiveBottomUp(binaryTreeHeight.root),4);
    }


}
