package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class MergeSortedLinkedListTest {

    MergeSortedLinkedList mergeSortedLinkedList1 = new MergeSortedLinkedList();
    MergeSortedLinkedList mergeSortedLinkedList2 = new MergeSortedLinkedList();
    MergeSortedLinkedList mergeSortedLinkedList3 = new MergeSortedLinkedList();

    @Test
    public void test() throws Exception {
        mergeSortedLinkedList1.insertFirst(2);
        mergeSortedLinkedList1.insertLast(10);
        mergeSortedLinkedList1.insertLast(15);

        mergeSortedLinkedList2.insertFirst(5);
        mergeSortedLinkedList2.insertLast(8);
        mergeSortedLinkedList2.insertLast(20);

        mergeSortedLinkedList3.mergeSortedList(mergeSortedLinkedList1.getFirstNode(),mergeSortedLinkedList2.getFirstNode());



    }
}
