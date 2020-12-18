package com.abn.dsalgos.challenges.string;

/*
Given a string s, the power of the string is the maximum length of a non-empty substring that
contains only one unique character.

Return the power of the string.
 */

public class ConsecutiveCharacters {

    public int consecutiveCharacters(String str) {

        char current=str.charAt(0);
        int maxCount=1;
        int temp = 1;

        for(int i =1; i< str.length(); i++) {
            if(current == str.charAt(i)) {
                temp += 1;
            } else {
                current = str.charAt(i);
                temp = 1;
            }

            if(maxCount < temp) {
                maxCount = temp;
            }
        }
        return maxCount;
    }
}
