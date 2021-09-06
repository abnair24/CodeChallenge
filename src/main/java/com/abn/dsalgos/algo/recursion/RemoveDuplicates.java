package com.abn.dsalgos.algo.recursion;

/*
When given a string that has repeating adjacent characters, we only want to keep one of each character.
To do this, we must eliminate the
repeating characters. The illustration below shows this process.

"Helllo Woorld" -> "Helo World"

"Thiss iss aa testt" -> "This is a test"
 */
public class RemoveDuplicates {

    public String remDuplicates(String text) {

        //Base case
        if (text.length() == 1) {
            return text;
        }

        if (text.substring(0, 1).equals(text.substring(1, 2))) {
            return remDuplicates(text.substring(1));
        } else {
            return text.charAt(0) + remDuplicates(text.substring(1));
        }
    }
}
