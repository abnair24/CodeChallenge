package com.abn.dsalgos.glc;

/*
Given a Binary String.
Replace all "01" to "10" until it's no more possible. In 1 second you replace all "01" to "10" in next second keep
repeating this procedure.
Return the total seconds to complete this.

eg: 0101->1010->1100 ans:2

Example :
String s = "001011";
For operation 1: 010101
For operation 2: 101010
For operation 3: 110100
For operation 4: 111000
Output : 4
 */
public class ReplacePattern {

    public int replace(String input) {

        int count =0;

        while(input.contains("01")) {

            input = input.replaceAll("01", "10");
            count = count + 1;
        }

        return count;
    }


    public static void main(String[] args) {

        ReplacePattern replacePattern = new ReplacePattern();
        System.out.println(replacePattern.replace("0101"));
        System.out.println(replacePattern.replace("001011"));
        System.out.println(replacePattern.replace("011010101001010"));
        System.out.println(replacePattern.replace("01101"));

    }
}
