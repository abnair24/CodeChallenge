package com.abn.dsalgos.algo.DFS;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeLCARecursionTest {

    BinaryTreeLCARecursion binaryTreeLCARecursion = new BinaryTreeLCARecursion();

    @Test
    public void test()
            throws Exception {
        MyTreeNode<Integer> node1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(8);

        binaryTreeLCARecursion.root = node1;
        binaryTreeLCARecursion.root.left = node2;
        binaryTreeLCARecursion.root.left.right = node3;
        binaryTreeLCARecursion.root.right = node4;
        binaryTreeLCARecursion.root.right.left = node5;
        binaryTreeLCARecursion.root.right.right = node6;
        binaryTreeLCARecursion.root.right.left.left = node7;
        binaryTreeLCARecursion.root.right.left.right = node8;

        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node6, node7), node4);
        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node5, node8), node5);
        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node4, node6), node4);
        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node2, node5), node1);
        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node4, node7), node4);
    }

    @Test
    public void test1()
            throws Exception {
        MyTreeNode<Integer> node1 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node2 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(2);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(0);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(8);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node9 = new MyTreeNode<>(4);

        binaryTreeLCARecursion.root = node1;
        binaryTreeLCARecursion.root.left = node2;
        binaryTreeLCARecursion.root.right = node3;
        binaryTreeLCARecursion.root.left.left = node4;
        binaryTreeLCARecursion.root.left.right = node5;
        binaryTreeLCARecursion.root.left.right.left = node8;
        binaryTreeLCARecursion.root.left.right.right = node9;
        binaryTreeLCARecursion.root.right.left = node6;
        binaryTreeLCARecursion.root.right.right = node7;

        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node2, node3), node1);
        Assert.assertEquals(binaryTreeLCARecursion.lowestCommonAncestor(node1, node9, node3), node1);
    }
}
