package com.abn.dsalgos.challenges.binaryTree;

import com.abn.dsalgos.utils.MyTreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.INavigatorPanel;

public class BinaryTreeLowestCommonAncestorTest {

    BinaryTreeLowestCommonAncestor<Integer>binaryTreeLowestCommonAncestor = new BinaryTreeLowestCommonAncestor<>();

    @Test
    public void test() throws Exception {
        MyTreeNode<Integer> node1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<>(4);
        MyTreeNode<Integer> node4 = new MyTreeNode<>(3);
        MyTreeNode<Integer> node5 = new MyTreeNode<>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<>(7);
        MyTreeNode<Integer> node8 = new MyTreeNode<>(8);

        binaryTreeLowestCommonAncestor.root = node1;
        binaryTreeLowestCommonAncestor.root.left = node2;
        binaryTreeLowestCommonAncestor.root.left.right = node3;
        binaryTreeLowestCommonAncestor.root.right = node4;
        binaryTreeLowestCommonAncestor.root.right.left = node5;
        binaryTreeLowestCommonAncestor.root.right.right = node6;
        binaryTreeLowestCommonAncestor.root.right.left.left = node7;
        binaryTreeLowestCommonAncestor.root.right.left.right = node8;

        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1,node6, node7),node4.data);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1,node5,node8),node5.data);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1,node4,node6),node4.data);
        Assert.assertEquals(binaryTreeLowestCommonAncestor.lowestCommonAncestor(node1,node2,node5),node1.data);
    }
}
