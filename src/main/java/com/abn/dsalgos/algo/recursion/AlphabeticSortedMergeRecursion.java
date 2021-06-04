package com.abn.dsalgos.algo.recursion;

/*
 given two strings that are in alphabetic order,  combine them to create a
 string that is both sorted alphabetically and the combination of those two strings.

 str1 => "cnt"
 str2 => "ace"

 str => accent
 */

public class AlphabeticSortedMergeRecursion {

    public String mergeSortedAlphabets(String s1, String s2) {

        //base case
        if (s1.equals("")) {
            return s2;
        } else if (s2.equals("")) {
            return s1;
        }

        //recursive case
        if (s1.charAt(0) < s2.charAt(0)) {
            return s1.charAt(0) + mergeSortedAlphabets(s1.substring(1), s2);
        } else {
            return s2.charAt(0) + mergeSortedAlphabets(s1, s2.substring(1));
        }
    }
}
