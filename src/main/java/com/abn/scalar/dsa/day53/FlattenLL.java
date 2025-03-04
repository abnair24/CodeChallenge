package com.abn.scalar.dsa.day53;

class ListNode {

    int val;
    ListNode right;
    ListNode down;

    public ListNode(int val) {
        this.val = val;
        right = down = null;
    }
}

public class FlattenLL {

    public ListNode flatten(ListNode root) {

        if(root == null || root.right == null) {
            return root;
        }

        root.right = flatten(root.right);

        root = merge(root, root.right);

        return root;
    }

    private ListNode merge(ListNode headA, ListNode headB) {

        if(headA == null) {
            return headB;
        }

        if(headB == null) {
            return headA;
        }

        ListNode result;

        if(headA.val < headB.val) {
            result = headA;
            result.down = merge(headA.down, headB);
        } else {
            result = headB;
            result.down = merge(headB.down, headA);
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(3);
        root.down = new ListNode(7);
        root.down.down = new ListNode(7);
        root.down.down.down = new ListNode(8);

        root.right = new ListNode(4);
        root.right.down = new ListNode(11);

        root.right.right = new ListNode(20);
        root.right.right.down = new ListNode(24);

        root.right.right.right = new ListNode(20);
        root.right.right.right.down = new ListNode(21);

        FlattenLL flattenLL = new FlattenLL();
        flattenLL.flatten(root);

    }
}

