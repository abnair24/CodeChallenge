package com.abn.dsalgos.utils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public boolean isWord;
    public Map<Character, TrieNode> childNodes = new HashMap<>();

    public TrieNode() {}

}
