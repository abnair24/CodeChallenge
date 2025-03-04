package com.abn.scalar.dsa.day43;

/*
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1.

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]

 Output 1:

      2
    /   \
   1     3

Output 2:

      3
    /   \
   2     5
  /       \
 1         10
 */
public class ArrayToBST {

    public TreeNode sortedArrayToBST(final int[] A) {
        return construct(A, 0, A.length - 1);
    }

    private TreeNode construct(int[] array, int start, int end) {

        if(start > end) {
            return null;
        }

        int m = (start + end) /2;

        TreeNode root =  new TreeNode(array[m]);
        root.left = construct(array, start, m-1);
        root.right = construct(array,m+1, end);
        return root;
    }

    public static void main(String[] args) {

        ArrayToBST array = new ArrayToBST();
        System.out.println(array.sortedArrayToBST(new int[] {1, 2, 3, 5, 10}).val);

        System.out.println(array.sortedArrayToBST(new int[] {-1, 3, 4, 6, 7, 8, 10, 13, 14}).val);
    }
}
