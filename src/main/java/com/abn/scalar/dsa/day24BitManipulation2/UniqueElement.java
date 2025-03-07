package com.abn.scalar.dsa.day24BitManipulation2;

/*
Every element appears thrice except one. Find the unique
element
I/p 4 5 5 4 1 6 6 4 5 6

o/p: 1

Approach:

Add ith position bits of all numbers; if sum of ith bit is not multiple of 3, then it is set as part of number which is not 3 times

4:  0 1 0 0
5:  0 1 0 1
5:  0 1 0 1
4:  0 1 0 0
1:  0 0 0 1
6:  0 1 1 0
6:  0 1 1 0
4:  0 1 0 0
5:  0 1 0 1
6:  0 1 1 0
===================
    0 9 3 4
 */
public class UniqueElement {

    public int solve(int[] array) {
        int ans = 0;

        for(int i = 0; i <= 32; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if ((array[j] & (1 << i)) != 0) {
                    count++;
                }
            }

            if (count % 3 > 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
     }

    public static void main(String[] args) {

        UniqueElement uniqueElement = new UniqueElement();
        System.out.println(uniqueElement.solve(new int[] {
                890,992,172,479,973,901,417,215,901,283,788,102,726,609,379,587,630,283,10,707,203,417,382,601,713,290,489,374,203,680,108,463,290,290,382,886,584,406,809,601,176,11,554,801,166,303,308,319,172,619,400,885,203,463,303,303,885,308,460,283,406,64,584,973,572,194,383,630,395,901,992,973,938,609,938,382,169,707,680,965,726,726,890,383,172,102,10,308,10,102,587,809,460,379,713,890,463,108,108,811,176,169,313,886,400,319,22,885,572,64,120,619,313,3,460,713,811,965,479,3,247,886,120,707,120,176,374,609,395,811,406,809,801,554,3,194,11,587,169,215,313,319,554,379,788,194,630,601,965,417,788,479,64,22,22,489,166,938,66,801,374,66,619,489,215,584,383,66,680,395,400,166,572,11,992
        }));
    }
}
