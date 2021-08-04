package com.abn.dsalgos.challenges.trie;

import java.util.HashMap;
import java.util.Map;

public class ReplaceWordsUsingMap {

    public String replace(String s, String[] array) {

        Map<String, Integer> map = new HashMap<>();

        for(String str : array) {
            map.put(str, str.length());
        }

        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String s1: split) {
            for (String key : map.keySet()) {

                if(s1.startsWith(key)) {
                    s1 = key;
                }
            }
            sb.append(s1 + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReplaceWordsUsingMap rep = new ReplaceWordsUsingMap();
        System.out.println(rep.replace("it is abnormal that this solution is accepted", new String[]{"ac","ab"}));
    }
}
