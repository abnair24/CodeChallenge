package com.abn.learn.dsa.day26Recursion2;

public class PalindromeRecursion {

    public int palindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        return isPalin(s, left, right);
    }

    private int isPalin(String s, int left, int right) {

        if(left >= right) {
            return 1;
        }

        if(s.charAt(left) != s.charAt(right)) {
            return 0;
        }

        return isPalin(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        PalindromeRecursion palindromeRecursion = new PalindromeRecursion();
        System.out.println(palindromeRecursion.palindrome("vegetable"));
    }
}
