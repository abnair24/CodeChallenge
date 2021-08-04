package com.abn.dsalgos.challenges.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNod {

    Map<Character, TrieNod> children;
    String word = null;

    public TrieNod() {
        children = new HashMap<>();
    }
}

public class ReplaceWordsTrie {

    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNod trie = new TrieNod();

        for (String str : dictionary) {
            TrieNod current = trie;
            for (char c : str.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNod());
                current = current.children.get(c);
            }
            current.word = str;
        }

        StringBuilder sb = new StringBuilder();

        String[] sentSplit = sentence.split("\\s+");

        for (String se : sentSplit) {
            TrieNod tempNode = trie;

            for (char c : se.toCharArray()) {
                if (tempNode.children.get(c) == null || tempNode.word != null) {
                    break;
                }
                tempNode = tempNode.children.get(c);
            }
            sb.append(tempNode.word != null ? tempNode.word + " " : se + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReplaceWordsTrie rep = new ReplaceWordsTrie();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(rep.replaceWords(dictionary, "the cattle was rattled by the battery"));
    }
}
