package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListCycleTest {

    LinkedListCycle<Integer> list = new LinkedListCycle<>();

    @Test
    public void loopTest() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(4);
        LinkNode<Integer> node5 = new LinkNode<>(5);
        LinkNode<Integer> node6 = new LinkNode<>(6);
        LinkNode<Integer> node7 = new LinkNode<>(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;

        list.insertFirst(node1.data);
        Assert.assertTrue(list.findLinkedListCycle(node1));
    }

    @Test
    public void noLoopTest() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(4);
        LinkNode<Integer> node5 = new LinkNode<>(5);
        LinkNode<Integer> node6 = new LinkNode<>(6);
        LinkNode<Integer> node7 = new LinkNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        list.insertFirst(node1.data);
        Assert.assertFalse(list.findLinkedListCycle(node1));
    }

    @Test
    public void singleElementLoopTest() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);

        node1.next = node1;

        list.insertFirst(node1.data);
        Assert.assertTrue(list.findLinkedListCycle(node1));
    }

    @Test
    public void fullLoopTest() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(4);
        LinkNode<Integer> node5 = new LinkNode<>(5);
        LinkNode<Integer> node6 = new LinkNode<>(6);
        LinkNode<Integer> node7 = new LinkNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node1;

        list.insertFirst(node1.data);
        Assert.assertTrue(list.findLinkedListCycle(node1));
    }

    @Test
    public void lastNodeLoopTest() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(4);
        LinkNode<Integer> node5 = new LinkNode<>(5);
        LinkNode<Integer> node6 = new LinkNode<>(6);
        LinkNode<Integer> node7 = new LinkNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node7;

        list.insertFirst(node1.data);
        Assert.assertTrue(list.findLinkedListCycle(node1));
    }

}
