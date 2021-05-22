package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import org.testng.annotations.Test;

public class ReorderLinkedListTest {

    public ReorderLinkedList<Integer> list = new ReorderLinkedList<>();

    @Test
    public void test1() throws Exception {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3= new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(4);
        LinkNode<Integer> node5 = new LinkNode<>(5);
        LinkNode<Integer> node6 = new LinkNode<>(6);
        LinkNode<Integer> node7 = new LinkNode<>(7);
        LinkNode<Integer> node8 = new LinkNode<>(8);
        LinkNode<Integer> node9 = new LinkNode<>(9);
        LinkNode<Integer> node10 = new LinkNode<>(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = null;

        list.print(list.reorderLinkedList(node1));

    }

    @Test
    public void test2() throws Exception{
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3= new LinkNode<>(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        list.print(list.reorderLinkedList(node1));
    }

    @Test
    public void test3() throws Exception{
        LinkNode<Integer> node1 = new LinkNode<>(1);

        node1.next = null;

        list.print(list.reorderLinkedList(node1));
    }

    @Test
    public void test4() throws Exception{
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);

        node1.next = node2;
        node2.next = null;

        list.print(list.reorderLinkedList(node1));
    }

    @Test
    public void test5() throws Exception {
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

        list.print(list.reorderLinkedList(node1));
    }
}
