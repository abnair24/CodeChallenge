package com.abn.dsalgos.algo.recursion;

public class VowelsInStringRecursion {

    public int vowelCount(String str) {

        String vowel = "aeiou";

        if(str.length() == 0) {
            return 0;
        }

        if (vowel.contains(String.valueOf(str.charAt(0)).toLowerCase())) {
            return 1 + vowelCount(str.substring(1));
        } else {
            return vowelCount(str.substring(1));
        }
    }
}
