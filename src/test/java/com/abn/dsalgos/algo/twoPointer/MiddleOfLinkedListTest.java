package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.MiddleOfLinkedList;
import com.abn.dsalgos.utils.ListNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MiddleOfLinkedListTest {

    MiddleOfLinkedList middleOfLinkedList;

    @BeforeMethod
    public void before() throws Exception {
        middleOfLinkedList = new MiddleOfLinkedList();
    }

    @Test
    public void test1() throws Exception {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        Assert.assertEquals(middleOfLinkedList.middleNode(l1).val,4);

    }
}
