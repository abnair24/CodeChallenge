package com.abn.dsalgos.utils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public HashMap<Character,TrieNode>childNodes = new HashMap<>();
    private boolean isLeaf;
    private Character character;

    public TrieNode() {

    }

    public TrieNode(Character character) {
        this.character = character;
    }
}
