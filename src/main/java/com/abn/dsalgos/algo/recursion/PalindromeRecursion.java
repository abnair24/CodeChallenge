package com.abn.dsalgos.algo.recursion;

public class PalindromeRecursion {

    public boolean isPalindrome(String str) {

        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }
}
