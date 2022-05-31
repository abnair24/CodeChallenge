package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.

Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"
 */

public class StringCaseChangePermutation {

    List<String> result = new ArrayList<>();

    public List<String> permutationString(String s) {

        char[] ch = s.toCharArray();
        backtrack(ch, 0);
        return result;
    }

    private void backtrack(char[] ch, int start) {

        System.out.println(result);
        result.add(new String(ch));

        for(int i = start; i < ch.length; i++) {
            char c = ch[i];
            if (Character.isLetter(c)) {
                ch[i] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                backtrack(ch, i + 1);
                ch[i] = c;
            }
        }
    }

    public static void main(String[] args) {
        StringCaseChangePermutation stringCaseChangePermutation = new StringCaseChangePermutation();
        System.out.println(stringCaseChangePermutation.permutationString("abc"));
    }

}
