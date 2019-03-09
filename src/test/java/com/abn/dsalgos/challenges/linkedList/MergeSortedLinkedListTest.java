package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class MergeSortedLinkedListTest {

    MergeSortedLinkedList mergeSortedLinkedList1 = new MergeSortedLinkedList();
    MergeSortedLinkedList mergeSortedLinkedList2 = new MergeSortedLinkedList();
    MergeSortedLinkedList mergeSortedLinkedList3 = new MergeSortedLinkedList();

    @Test
    public void test() throws Exception {
        mergeSortedLinkedList1.insertFirst(1);
        mergeSortedLinkedList1.insertLast(6);
        mergeSortedLinkedList1.insertLast(8);
        mergeSortedLinkedList1.insertLast(10);

        mergeSortedLinkedList2.insertFirst(2);
        mergeSortedLinkedList2.insertLast(4);
        mergeSortedLinkedList2.insertLast(5);
        mergeSortedLinkedList2.insertLast(7);
        mergeSortedLinkedList2.insertLast(9);
        mergeSortedLinkedList2.insertLast(11);

        mergeSortedLinkedList3.mergeSortedList(mergeSortedLinkedList1.getFirstNode(),mergeSortedLinkedList2.getFirstNode());



    }
}
