package com.abn.dsalgos.algo.backtrack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {


        List<String > list = Arrays.asList("54", "546", "548", "60");

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;


                return XY.compareTo(YX);
            }
        });

        list.toString();

        String s1 = "463";
        String s2 = "365";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Character[] charArray1 = new Character[s1.length()];
        Character[] charArray2 = new Character[s2.length()];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s1.length(); i++) {
            charArray1[i] = s1.charAt(i);

        }
        for(int i = 0; i < s2.length(); i++) {
            charArray2[i] = s2.charAt(i);
        }

        Arrays.sort(charArray1, (n1, n2) -> n2 - n1);

        System.out.println(charArray1);

        Arrays.sort(charArray2, (n1, n2) -> n2 - n1);
    }
}
