package com.abn.scalar.dsa.day24BitManipulation2;

/*
Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder after the dividing the answer by 10^9+7.

A = [1, 2, 3]

Pair    Xor
{1, 2}  3
{1, 3}  2
{2, 3}  1
Sum of xor of all pairs = 3 + 2 + 1 = 6.

A = [3, 4, 2]
Pair    Xor
{3, 4}  7
{3, 2}  1
{4, 2}  6
Sum of xor of all pairs = 7 + 1 + 6 = 14.

Approach

For every bit, we can find the number of elements in the array
with that bit set and the number of elements with that bit unset.

Let the number of elements with i-th bit set and unset be
X and Y respectively.

Now the number of xor pairs with the i-th bit set is X*Y.
So the total contribution by the i-th bit to the sum of xor
of all pairs will be (X * Y) * (1 << i).
 */
public class SumOfAllXorPair {

    public int sum(int[] array) {

        long ans = 0;

        for(int i = 0; i < 32; i++) {
            long countOfSetBits = 0;

            for(int k : array) {
                countOfSetBits += (k >> i) & 1;
            }
            // for unset bits array length - set bits for ith position
            ans = (ans + countOfSetBits * (array.length - countOfSetBits) * (1 << i)) % 1000000007;
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        SumOfAllXorPair sumOfAllXorPair = new SumOfAllXorPair();
        System.out.println(sumOfAllXorPair.sum(new int[] {1, 2, 3}));
    }


}
