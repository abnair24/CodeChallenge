package com.abn.scalar.dsa.day52;

import com.abn.dsalgos.utils.ListNode;

import java.util.Stack;

/*
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 */
public class PalindromLL {

    public int solution(ListNode A) {
        return isPalindrome(A) ? 1: 0;
    }

    public boolean isPalindrome(ListNode A) {

        ListNode temp = A;
        Stack<Integer> stack = new Stack<>();
        boolean status = false;
        int size = 0;
        ListNode current = A;

        while(current != null) {
            size ++;
            current = current.next;
        }

        if(size == 1) {
            return true;
        }

        for (int i = 0; i < size / 2; i++) {
            stack.push(temp.val);
            temp = temp.next;
        }
        /*
        for odd number length, skip the middle one from getting added to stack
         */
        if (size % 2 != 0) {
            temp = temp.next;
        }

        while (temp != null) {
            if (temp.val == (int) stack.peek()) {
                status = true;
                stack.pop();
                temp = temp.next;
            } else {
                status = false;
                break;
            }
        }
        return status;
    }
}
