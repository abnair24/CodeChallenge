package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class RemoveDuplicateLinkedListTest {

    RemoveDuplicateLinkedList<Integer> rm = new RemoveDuplicateLinkedList<>();

    @Test
    public void test() throws Exception {
        rm.insertFirst(1);
        rm.insertLast(1);
        rm.insertLast(2);
        rm.insertLast(2);
        rm.insertLast(2);
        rm.insertLast(3);
        rm.insertLast(4);
        rm.insertLast(4);
        rm.insertLast(5);
        rm.insertLast(5);
        rm.insertLast(6);

        rm.removeDuplicate(rm.getFirstNode());
    }
}
