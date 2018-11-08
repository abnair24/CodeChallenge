package com.abn.dsalgos.challenges.BST;


import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeKthSmallestTest {

    BinarySearchTreeKthSmallest<Integer> binarySearchTreeKthSmallest = new BinarySearchTreeKthSmallest<>();

    @Test
    public void test() throws Exception {

        MyBSTNode<Integer> node1 = new MyBSTNode<Integer>(5);
        MyBSTNode<Integer> node2 = new MyBSTNode<Integer>(3);
        MyBSTNode<Integer> node3 = new MyBSTNode<Integer>(8);
        MyBSTNode<Integer> node4 = new MyBSTNode<>(10);
        MyBSTNode<Integer> node5 = new MyBSTNode<>(1);
        MyBSTNode<Integer> node6 = new MyBSTNode<>(4);
        MyBSTNode<Integer> node7 = new MyBSTNode<>(7);

        binarySearchTreeKthSmallest.insertNode(node1);
        binarySearchTreeKthSmallest.insertNode(node2);
        binarySearchTreeKthSmallest.insertNode(node3);
        binarySearchTreeKthSmallest.insertNode(node4);
        binarySearchTreeKthSmallest.insertNode(node5);
        binarySearchTreeKthSmallest.insertNode(node6);
        binarySearchTreeKthSmallest.insertNode(node7);

        binarySearchTreeKthSmallest.display(node1);

        Assert.assertEquals(binarySearchTreeKthSmallest.kthSmallest(node1,3).intValue(),4);
        Assert.assertNull(binarySearchTreeKthSmallest.kthSmallest(node1,8));
        Assert.assertEquals(binarySearchTreeKthSmallest.kthSmallest(node1,4).intValue(),5);
        Assert.assertEquals(binarySearchTreeKthSmallest.kthSmallest(node1,6).intValue(),8);
    }

}
