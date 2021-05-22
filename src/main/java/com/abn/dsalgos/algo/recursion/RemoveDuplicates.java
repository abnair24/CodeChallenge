package com.abn.dsalgos.algo.recursion;

public class RemoveDuplicates {

    public String remDuplicates(String text) {
        if (text.length() == 1) {
            return text;
        }

        if (text.substring(0,1).equals(text.substring(1,2))) {
            return remDuplicates(text.substring(1));
        }
        else {
            return text.charAt(0) + remDuplicates(text.substring(1));
        }
    }
}
