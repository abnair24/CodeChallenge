package com.abn.dsalgos.challenges.string;

/*
Check whether two strings are anagram of each other

 */

import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
