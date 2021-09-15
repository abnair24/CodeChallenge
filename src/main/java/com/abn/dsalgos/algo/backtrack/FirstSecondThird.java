package com.abn.dsalgos.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class FirstSecondThird {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();

        String[] array = text.split(" ");
        int len = array.length;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(first)) {
                if ((i + 1) < len && array[i + 1].equals(second)) {
                    if ((i + 2) < len) {
                        result.add(array[i + 2]);
//                        i = i + 2;
                    }
                }
            }
        }

        String[] strArray = result.toArray(new String[0]);
        return strArray;
    }

    public static void main(String[] args) {

        FirstSecondThird firstSecondThird = new FirstSecondThird();
        firstSecondThird.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa"
                , "kcyxdfnoa", "jkypmsxd");
    }
}
