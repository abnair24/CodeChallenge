package com.abn.dsalgos.challenges.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

    public String replaceWords(List<String> roots, String sentence) {

        Set<String> hs = new HashSet<>();

        for(String root : roots) {
            hs.add(root);
        }

        String[] replacedString = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(String s: replacedString) {
            String prefix = "";
            for(int i = 1; i<=s.length(); i++) {
                prefix = s.substring(0, i);
                if(hs.contains(prefix)) {
                    break;
                }
            }

            if(sb.length() > 0 ) {

                sb.append(" ");
            }
            sb.append(prefix);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();

        List<String> roots = new ArrayList<>();
        roots.add("cat");
        roots.add("bat");
        roots.add("rat");

        String sentence = "the cattle was rattled by the battery";
        replaceWords.replaceWords(roots, sentence);
    }
}
