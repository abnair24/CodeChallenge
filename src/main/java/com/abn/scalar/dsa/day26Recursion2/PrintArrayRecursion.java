package com.abn.scalar.dsa.day26Recursion2;

/*
You are given an array A. Print the elements of the array using recursion.
Print the elements of the array in the sequential order.

A = [6, -2, 5, 3]

6 -2 5 3
 */
public class PrintArrayRecursion {

    public void solve(int[] A) {
        printArray(A, 0);
        System.out.println();
    }

    private void printArray(int[] array,int index) {

        if(index == array.length) {
            return;
        }

        System.out.print(array[index] + " ");
        printArray(array, index + 1);
    }

    public static void main(String[] args) {

        PrintArrayRecursion printArrayRecursion = new PrintArrayRecursion();
        printArrayRecursion.solve(new int[] {-8, 6, -9, 4, 0, 2, 1});
    }
}
