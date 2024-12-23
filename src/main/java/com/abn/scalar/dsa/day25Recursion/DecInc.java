package com.abn.scalar.dsa.day25Recursion;

/*

Print N numbers in Decreasing Order and then in Increasing Order.

You are given a positive number N.
You are required to print the numbers from N to 1.
You are required to not use any loops. Don't change the signature of the function DecThenInc function.
Note : Please print an new line after printing the output.
A single line having number printed from N to 1 and then from 1 to N.

Input: 4
Output: 4 3 2 1 1 2 3 4

 */
public class DecInc {

    private void decreasingIncreasing(int N) {
        if(N == 0) {
            return;
        }
        System.out.print(N + " ");
        decreasingIncreasing(N - 1);
        System.out.print(N + " ");
    }

    public void decrIncr(int N) {
        decreasingIncreasing(N);
        System.out.println();
    }

    public static void main(String[] args) {

        DecInc decInc = new DecInc();
        decInc.decrIncr(4);
    }
}


