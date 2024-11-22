package com.abn.learn.dsa.day17;

/*
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings
in the array.


The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of
both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]

Output 1:
"a"

Input 2:
A = ["abab", "ab", "abcd"];

Output 2:
"ab"

 */
public class LongestCommonPrefix {

    public String solve(String[] array) {

        int len = array.length;

        if(len == 1) {
            return array[0];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < array[0].length(); i++) {

            int arrayElement = 1;
            for(int j = arrayElement; j < len; j++ ) {

                if(array[j].length() <= i) {
                    break;
                }

                if(array[j].charAt(i) != array[0].charAt(i)) {
                    break;
                }
                arrayElement ++;
            }

            // Condition to check if first and second matches and third string in array is not matching, then break from loop.
            if(arrayElement != len ) {
                break;
            }

            sb.append(array[0].charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.solve(new String[] {"abcd", "abcd", "efgh"}));
        System.out.println(longestCommonPrefix.solve(new String[] {"aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}));
        System.out.println(longestCommonPrefix.solve(new String[] {"aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaa","aaaaaa","aaaaa"}));

    }
}
