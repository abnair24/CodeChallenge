package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.SingleLinkedListPalindrome;
import com.abn.dsalgos.utils.ListNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleLinkedListPalindromeTest {

   SingleLinkedListPalindrome list;

    @BeforeMethod
    public void setup() throws Exception {
        list = new SingleLinkedListPalindrome();
    }

    @Test
    public void palindromeTest() throws Exception {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        Assert.assertTrue(list.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);

        System.out.println(list.isPalindrome(head));
    }
}
