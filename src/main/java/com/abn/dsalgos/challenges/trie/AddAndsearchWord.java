package com.abn.dsalgos.challenges.trie;

import java.util.HashMap;
import java.util.Map;


class TrieN {

    Map<Character, TrieN> children;
    boolean isWord;

    public TrieN() {
        children = new HashMap<>();
    }
}

public class AddAndsearchWord {

    TrieN root;

    public AddAndsearchWord() {
        root = new TrieN();
    }

    public void addWord(String str) {

        TrieN current = root;

        for (char ch : str.toCharArray()) {

            current.children.putIfAbsent(ch, new TrieN());
            current = current.children.get(ch);
        }

        current.isWord = true;
    }

    public boolean search(String word) {

        return searchHelper(word, root);
    }

    private boolean searchHelper(String word, TrieN current) {

        for (int i = 0; i < word.length(); i++) {

            if (current.children.containsKey(word.charAt(i))) {
                current = current.children.get(word.charAt(i));
            } else {

                if (word.charAt(i) == '.') {
                    for (char ch : current.children.keySet()) {
                        boolean status = searchHelper(word.substring(i + 1), current.children.get(ch));
                        if (status) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return current.isWord;
    }

    public static void main(String[] args) {
        AddAndsearchWord addAndsearchWord = new AddAndsearchWord();
        addAndsearchWord.addWord("bad");
        addAndsearchWord.addWord("bat");
        addAndsearchWord.addWord("dad");
        addAndsearchWord.addWord("pad");
        System.out.println(addAndsearchWord.search(".ad"));
        System.out.println(addAndsearchWord.search("ba."));
    }
}
