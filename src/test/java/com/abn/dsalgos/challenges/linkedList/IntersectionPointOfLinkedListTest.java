package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import org.testng.annotations.Test;

public class IntersectionPointOfLinkedListTest {

    IntersectionPointOfLinkedList<Integer> list1 = new IntersectionPointOfLinkedList<>();

    @Test
    public void sameLengthTest() {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        LinkNode<Integer> node4 = new LinkNode<>(1);
        LinkNode<Integer> node5 = new LinkNode<>(1);
        LinkNode<Integer> node6 = new LinkNode<>(1);
        LinkNode<Integer> node7 = new LinkNode<>(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node6.next = node7;
        node7.next = node3;

        System.out.println(list1.findIntersection2(node1, node6));
    }

    @Test
    public void diffLengthTest() {

    }

    @Test
    public void singleListTest() {

    }

    @Test
    public void nullListsTest() {

    }
}
