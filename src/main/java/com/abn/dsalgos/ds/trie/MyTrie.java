package com.abn.dsalgos.ds.trie;

import com.abn.dsalgos.utils.TrieNode;

public class MyTrie {

    public TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }

            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(current.children.get(c) == null) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if(current.children.get(c) == null) {
                return false;
            }
            current = current.children.get(c);
        }
       return true;
    }
}
