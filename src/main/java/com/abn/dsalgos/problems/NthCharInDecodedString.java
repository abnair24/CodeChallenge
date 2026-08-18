package com.abn.dsalgos.problems;

/*

String a3b4c1k1
Decode and output at Kth position:

 */
public class NthCharInDecodedString {

    public static String decodeChar(String input, int pos) {

        int runLength = 0;

        for (int i = 1; i < input.length(); i = i + 2) {
            runLength = runLength + Character.getNumericValue(input.charAt(i));

            if (runLength >= pos) {

                return Character.toString(input.charAt(i - 1));
            }
        }
        return "-1";
    }

    public static void main(String[] args) {

        System.out.println(decodeChar("a1b1c3", 2));
    }
}
