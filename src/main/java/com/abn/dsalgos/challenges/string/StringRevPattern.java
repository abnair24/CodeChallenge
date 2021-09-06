package com.abn.dsalgos.challenges.string;


/*
Given 2 strings and integer, the ouput should be

String input1 = "abc"
String input2 = "xyz"
int k = 2

output = "abczyxcbaxyz"

if k = 5

output ="abczyxcbaxyzabczyxcbaxyzabczyx"
 */

public class StringRevPattern {

    public String revPattern(String a, String b, int k) {

        String aRev = reverse(a);
        String bRev = reverse(b);

        StringBuilder sb1 = new StringBuilder();

        String p1 = a + bRev;
        String p2 = aRev + b;

        for (int i = 1; i <= k; i++) {
            if (i % 2 == 0) {
                sb1.append(p2);
            } else {
                sb1.append(p1);
            }
        }
        return sb1.toString();
    }

    private String reverse(String str) {

        StringBuilder sb = new StringBuilder();
        int len = str.length();

        for (int i = len - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
