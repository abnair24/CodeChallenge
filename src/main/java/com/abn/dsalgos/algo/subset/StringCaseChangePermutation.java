package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.

Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"
 */
public class StringCaseChangePermutation {

    public static void main(String[] args) {
        StringCaseChangePermutation stringCaseChangePermutation = new StringCaseChangePermutation();
        System.out.println(stringCaseChangePermutation.permutationString("abc70S"));
    }

    public List<String> permutationString(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        result.add(s);

        while (i < s.length()) {

            if (Character.isLetter(s.charAt(i))) {
                int size = result.size();

                for (int j = 0; j < size; j++) {
                    char[] chs = result.get(j).toCharArray();
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    result.add(String.valueOf(chs));
                }
            }
            i++;
        }
        return result;
    }
}
