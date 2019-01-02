package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class LinkedListPushEvenNodesToEndTest {

    LinkedListPushEvenNodesToEnd<Integer> linkedListPushEvenNodesToEnd = new LinkedListPushEvenNodesToEnd<>();

    @Test
    public void test() throws Exception {
        linkedListPushEvenNodesToEnd.insertFirst(1);
        linkedListPushEvenNodesToEnd.insertLast(2);
        linkedListPushEvenNodesToEnd.insertLast(4);
        linkedListPushEvenNodesToEnd.insertLast(5);
        linkedListPushEvenNodesToEnd.insertLast(3);
        linkedListPushEvenNodesToEnd.insertLast(6);
        linkedListPushEvenNodesToEnd.insertLast(7);
        linkedListPushEvenNodesToEnd.insertLast(8);

        linkedListPushEvenNodesToEnd.pushEvenNodes();
    }

    @Test
    public void test1() throws Exception {
        linkedListPushEvenNodesToEnd.insertLast(2);
        linkedListPushEvenNodesToEnd.insertLast(4);


        linkedListPushEvenNodesToEnd.insertLast(6);

        linkedListPushEvenNodesToEnd.insertLast(8);

        linkedListPushEvenNodesToEnd.pushEvenNodes();
    }

    @Test
    public void test2() throws Exception {
        linkedListPushEvenNodesToEnd.insertFirst(1);


        linkedListPushEvenNodesToEnd.insertLast(5);
        linkedListPushEvenNodesToEnd.insertLast(3);

        linkedListPushEvenNodesToEnd.insertLast(7);


        linkedListPushEvenNodesToEnd.pushEvenNodes();
    }
}
