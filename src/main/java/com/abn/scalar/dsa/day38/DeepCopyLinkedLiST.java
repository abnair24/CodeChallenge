package com.abn.scalar.dsa.day38;

/*

You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

  Example Output

   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

 */
public class DeepCopyLinkedLiST {

    public RandomListNode solve(RandomListNode head) {

        RandomListNode current = head;
        while(current != null) {
            RandomListNode clone = new RandomListNode(current.label);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        current = head;
        while(current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        RandomListNode temp1 =head;
        RandomListNode temp2 =head.next;
        RandomListNode dh = temp2;

        while(temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1 != null) {
                temp2.next = temp1.next;
                temp2 = temp2.next;
            }
        }

        return dh;
    }
}

class RandomListNode {
    public int label;
    public RandomListNode next, random;
    RandomListNode(int x) { label = x; next = null; }
}


