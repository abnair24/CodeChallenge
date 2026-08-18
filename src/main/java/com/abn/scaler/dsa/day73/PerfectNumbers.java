package com.abn.scaler.dsa.day73;

/*
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 22
Output 2:

 1111

 Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.
 */
public class PerfectNumbers {

    public String solve(int A) {
        int length = 2;
        int count = 0;
        int previousCount = 0;

        while (count < A) {
            previousCount = count;
            count += (int) Math.pow(2, length / 2);
            if (count >= A) {
                break;
            }
            length += 2;
        }


        int positionInGroup = A - previousCount - 1; // 0-indexed

        StringBuilder firstHalf = new StringBuilder();
        int halfLength = length / 2;

        for (int i = halfLength - 1; i >= 0; i--) {
            if ((positionInGroup & (1 << i)) != 0) {
                firstHalf.append('2');
            } else {
                firstHalf.append('1');
            }
        }

        return firstHalf.toString() + new StringBuilder(firstHalf).reverse().toString();

    }

    public static void main(String[] args) {
        PerfectNumbers perfectNumbers = new PerfectNumbers();
        System.out.println(perfectNumbers.solve(2)); // Output: 22
        System.out.println(perfectNumbers.solve(3)); // Output: 1111
    }
}
