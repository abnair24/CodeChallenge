package com.abn.dsalgos.challenges.BST;


import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeKthSmallestLargestTest {

    BinarySearchTreeKthSmallestLargest<Integer> binarySearchTreeKthSmallestLargest = new BinarySearchTreeKthSmallestLargest<>();

    @Test
    public void test() throws Exception {

        MyBSTNode<Integer> node1 = new MyBSTNode<Integer>(5);
        MyBSTNode<Integer> node2 = new MyBSTNode<Integer>(3);
        MyBSTNode<Integer> node3 = new MyBSTNode<Integer>(8);
        MyBSTNode<Integer> node4 = new MyBSTNode<>(10);
        MyBSTNode<Integer> node5 = new MyBSTNode<>(1);
        MyBSTNode<Integer> node6 = new MyBSTNode<>(4);
        MyBSTNode<Integer> node7 = new MyBSTNode<>(7);

        binarySearchTreeKthSmallestLargest.insertNode(node1);
        binarySearchTreeKthSmallestLargest.insertNode(node2);
        binarySearchTreeKthSmallestLargest.insertNode(node3);
        binarySearchTreeKthSmallestLargest.insertNode(node4);
        binarySearchTreeKthSmallestLargest.insertNode(node5);
        binarySearchTreeKthSmallestLargest.insertNode(node6);
        binarySearchTreeKthSmallestLargest.insertNode(node7);

        binarySearchTreeKthSmallestLargest.display(node1);

        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthSmallest(node1,3).intValue(),4);
        Assert.assertNull(binarySearchTreeKthSmallestLargest.kthSmallest(node1,8));
        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthSmallest(node1,4).intValue(),5);
        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthSmallest(node1,6).intValue(),8);
    }

    @Test
    public void test1() throws Exception {

        MyBSTNode<Integer> node1 = new MyBSTNode<Integer>(5);
        MyBSTNode<Integer> node2 = new MyBSTNode<Integer>(3);
        MyBSTNode<Integer> node3 = new MyBSTNode<Integer>(8);
        MyBSTNode<Integer> node4 = new MyBSTNode<>(10);
        MyBSTNode<Integer> node5 = new MyBSTNode<>(1);
        MyBSTNode<Integer> node6 = new MyBSTNode<>(4);
        MyBSTNode<Integer> node7 = new MyBSTNode<>(7);

        binarySearchTreeKthSmallestLargest.insertNode(node1);
        binarySearchTreeKthSmallestLargest.insertNode(node2);
        binarySearchTreeKthSmallestLargest.insertNode(node3);
        binarySearchTreeKthSmallestLargest.insertNode(node4);
        binarySearchTreeKthSmallestLargest.insertNode(node5);
        binarySearchTreeKthSmallestLargest.insertNode(node6);
        binarySearchTreeKthSmallestLargest.insertNode(node7);

        binarySearchTreeKthSmallestLargest.display(node1);

        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthLargest(node1, 1).intValue(), 10);
        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthLargest(node1,7).intValue(),1);
        Assert.assertEquals(binarySearchTreeKthSmallestLargest.kthLargest(node1,3).intValue(),7);
    }

}
