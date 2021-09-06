package com.abn.dsalgos.challenges.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String str = "teeter";
        Map<Character, Integer> lhm = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            Integer i = lhm.get(c);

            if (i == null) {
                lhm.put(c, 1);
            } else {
                lhm.put(c, ++i);

            }
        }

        lhm.entrySet().stream().filter(ent -> ent.getValue() == 1).findFirst().ifPresent(ent -> System.out.println(ent.getKey()));

    }

}
