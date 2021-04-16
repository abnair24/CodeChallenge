package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.RotateSingleLinkedListKTimes;
import com.abn.dsalgos.utils.ListNode;
import org.testng.annotations.Test;

public class RotateSingleLinkedListKTimesTest {

    RotateSingleLinkedListKTimes list;

    @Test
    public void test() throws Exception {
        list = new RotateSingleLinkedListKTimes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        list.rotate(head, 2);
    }

    @Test
    public void test1() throws Exception {
        list = new RotateSingleLinkedListKTimes();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        list.rotate(head, 4);
    }

    @Test
    public void test2() {
        list = new RotateSingleLinkedListKTimes();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);

        list.rotate(head, 2);
    }


    @Test
    public void test3() {
        list = new RotateSingleLinkedListKTimes();
        ListNode head = new ListNode(1);

        list.rotate(head, 3);
    }

    @Test
    public void test4() {
        list = new RotateSingleLinkedListKTimes();

        list.rotate(null, 3);
    }

    @Test
    public void test5() {
        list = new RotateSingleLinkedListKTimes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        list.rotate(head, 0);
    }
}
