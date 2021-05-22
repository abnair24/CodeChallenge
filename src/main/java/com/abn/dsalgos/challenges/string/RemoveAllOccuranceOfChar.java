package com.abn.dsalgos.challenges.string;

import java.util.Arrays;

public class RemoveAllOccuranceOfChar {

    public String removeChars(String str, char ch) {
        int i,j, count =0;
        int len = str.length();

        char[] tempCharArray = str.toCharArray();

        for(i =j = 0; i< len;i++) {
            if(tempCharArray[i] == ch) {
                count ++;
            } else {
                tempCharArray[j++] = tempCharArray[i];
            }
        }

        while(count > 0) {
            tempCharArray[j++] = '\0';
            count -- ;
        }

        return Arrays.toString(tempCharArray);
    }
}
