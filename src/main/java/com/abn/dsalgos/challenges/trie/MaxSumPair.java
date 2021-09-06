package com.abn.dsalgos.challenges.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    int score;
}

public class MaxSumPair {

    HashMap<String, Integer> map;
    TrieNode root;

    public MaxSumPair() {
        map = new HashMap();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) {
                return 0;
            }
        }
        return cur.score;
    }

    public static void main(String[] args) {
        MaxSumPair maxSumPair = new MaxSumPair();
        maxSumPair.insert("apple", 3);
        maxSumPair.sum("ap");
        maxSumPair.insert("app", 5);
        maxSumPair.sum("ap");
        maxSumPair.insert("app", 3);
    }
}
