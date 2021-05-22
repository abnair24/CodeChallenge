package com.abn.dsalgos.challenges.BST;

import com.abn.dsalgos.utils.MyBSTNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InOrderSuccessorTest {

    InOrderSuccessor<Integer>inOrderSuccessor = new InOrderSuccessor<>();

    @Test
    public void test() throws Exception {
        MyBSTNode<Integer> node1 = new MyBSTNode<>(100);
        MyBSTNode<Integer> node2 = new MyBSTNode<>(150);
        MyBSTNode<Integer> node3 = new MyBSTNode<>(50);
        MyBSTNode<Integer> node4 = new MyBSTNode<>(25);
        MyBSTNode<Integer> node5 = new MyBSTNode<>(75);
        MyBSTNode<Integer> node6 = new MyBSTNode<>(125);
        MyBSTNode<Integer> node7 = new MyBSTNode<>(175);
        MyBSTNode<Integer> node8 = new MyBSTNode<>(120);
        MyBSTNode<Integer> node9 = new MyBSTNode<>(140);
        MyBSTNode<Integer> node10 = new MyBSTNode<>(160);
        MyBSTNode<Integer> node11 = new MyBSTNode<>(190);

        inOrderSuccessor.insertNode(node1);
        inOrderSuccessor.insertNode(node2);
        inOrderSuccessor.insertNode(node3);
        inOrderSuccessor.insertNode(node4);
        inOrderSuccessor.insertNode(node5);
        inOrderSuccessor.insertNode(node6);
        inOrderSuccessor.insertNode(node7);
        inOrderSuccessor.insertNode(node8);
        inOrderSuccessor.insertNode(node9);
        inOrderSuccessor.insertNode(node10);
        inOrderSuccessor.insertNode(node11);

        Assert.assertEquals(inOrderSuccessor.getSuccessor(node1,node5), node1);
        Assert.assertEquals(inOrderSuccessor.getSuccessor(node1,node4), node3);
        Assert.assertEquals(inOrderSuccessor.getSuccessor(node1,node6), node9);
        Assert.assertEquals(inOrderSuccessor.getSuccessor(node1,node2), node10);
        Assert.assertEquals(inOrderSuccessor.getSuccessor(node1,node11),null);
    }
}
