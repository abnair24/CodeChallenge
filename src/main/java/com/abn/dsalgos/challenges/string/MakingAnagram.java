package com.abn.dsalgos.challenges.string;

import java.util.HashMap;

public class MakingAnagram {

    public int makeAnagram(String s1, String s2) {
        s1 = s1.replace(" ", "").toLowerCase();
        s2 = s2.replace(" ", "").toLowerCase();

        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < s1.length(); i++) {

            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i)) && map.get(s2.charAt(i)) != 0) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                count++;
            }
        }

        if (map.size() != 0) {
            count += map.values().stream().mapToInt(v -> v).sum();
        }

        return count;
    }
}
