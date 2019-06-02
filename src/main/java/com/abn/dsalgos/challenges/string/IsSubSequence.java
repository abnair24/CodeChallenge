package com.abn.dsalgos.challenges.string;

/*
Given two strings, find if the first is a subsequence of the second

String1 = "AX" String2 = "AXQ" => YES
String1 = "AZ" String2 = "AXQ" => NO
String1 = "AXZ" String2 = "AFXCWZ" =>YES

 */
public class IsSubSequence {

    public boolean isSubSequence(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        boolean status = false;

        int k = 0;

        for(int i = 0; i< len1; i++) {
            status = false;
            for(int j=k;j<len2; j++) {
                if(str1.charAt(i)==str2.charAt(j)){
                    status = true;
                    k = j+1;
                }
            }
        }

        return status;
    }
}
