package com.abn.dsalgos.glc;

public class StringAlternateReverse {

    public static void main(String[] args) {

        String s = "Cloudera is a hybrid cloud native and on prem platform";
        StringAlternateReverse stringAlternateReverse = new StringAlternateReverse();
        System.out.println(stringAlternateReverse.reversedString(s));
    }

    public String reversedString(String str) {

        int len = str.length();
        int endPtr = len - 1;
        int startPtr = len - 1;
        int wordCount = 0;

        StringBuilder sb = new StringBuilder();

        StringBuilder temp = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {

            if (str.charAt(i) != ' ') {

                temp.append(str.charAt(i));
                startPtr = i;

            }
            if (str.charAt(i) == ' ' || i == 0) {

                if (wordCount % 2 != 0) {
                    sb.append(str, startPtr, endPtr + 1);
                } else {

                    sb.append(reverse(str.substring(startPtr, endPtr + 1)));
                }

                wordCount++;
                endPtr = i - 1;
                temp = new StringBuilder("");

                //To add the spaces to stringbuilder and avoid adding first char for the beginning word.
                if (i != 0) {
                    sb.append(str.charAt(i));
                }
            }
        }

        return sb.toString();
    }

    private String reverse(String str) {

        int len = str.length();

        StringBuilder reverse = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }

        return reverse.toString();
    }
}
