package com.abn.scalar.dsa.day53;

import com.abn.dsalgos.utils.ListNode;

import java.util.Stack;

public class PalindromLL {

    public int isPalindrome(ListNode A) {

        ListNode temp = A;
        Stack<Integer> stack = new Stack<>();
        boolean status = false;
        int size = 0;

        while(A != null) {
            size ++;
            A = A.next;
        }

        if(size == 1) {
            return 1;
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
            if (temp.val == stack.peek()) {
                status = true;
                stack.pop();
                temp = temp.next;
            } else {
                status = false;
                break;
            }
        }

        int s = !status ? 0 : 1;

        return s;
    }
}
