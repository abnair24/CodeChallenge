package com.abn.dsalgos.ds.stack;

import org.testng.Assert;

import java.util.Stack;

/*
You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair.
In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|' make a pair, and so forth.

Return the number of '*' in s, excluding the '*' between each pair of '|'.

Note that each '|' will belong to exactly one pair.

Input: s = "l|*e*et|c**o|*de|"
Output: 2
Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
The characters between the first and second '|' are excluded from the answer.
Also, the characters between the third and fourth '|' are excluded from the answer.
There are 2 asterisks considered. Therefore, we return 2.

Input: s = "yo|uar|e**|b|e***au|tifu|l"
Output: 5

https://leetcode.com/problems/count-asterisks/
 */
public class CountAsteriks {

    public int countAsterisks(String s) {

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for(int i = 0; i< s.length(); i++) {

            if( s.charAt(i) == '*' && stack.isEmpty()) {
                count ++;
            }
            if(s.charAt(i) == '|') {
                if(stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountAsteriks countAsteriks = new CountAsteriks();
        Assert.assertEquals(countAsteriks.countAsterisks("yo|uar|e**|b|e***au|tifu|l"), 5);
    }
}
