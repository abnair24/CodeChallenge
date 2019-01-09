package com.abn.dsalgos.ds.trie;

import com.abn.dsalgos.utils.TrieNode;

import java.util.HashMap;

public class MyTrie {

    public TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character,TrieNode> childNodes = root.childNodes;
        for(int i =0; i< word.length();i++) {
            char c = word.charAt(i);

            TrieNode temp;
            if(childNodes.containsKey(c)) {
                temp = childNodes.get(c);
            } else {
                temp = new TrieNode(c);
                childNodes.put(c,temp);
            }
            childNodes = temp.childNodes;
        }
    }
}
