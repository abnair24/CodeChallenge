package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an input string, return an output string such that all the lower case characters should be sorted.

Indices of non-lower case characters should remain the same as in the original input string.

Eg. Input -> 'Test@123 Google'
Output -> 'Teeg@123 Gloost'
 */
public class SortLowerCaseCharacter {

    public static int count = 0;

    private boolean isLowerCase(char ch) {

        return ch >= 'a' && ch <= 'z';
    }
    public String sortLowerCaseLessOn(String str) {

        int[] array = new int[27];
        Arrays.fill(array, 0);

        for(int i = 0; i < str.length(); i++) {

            if(Character.isLowerCase(str.charAt(i))) {
                array[str.charAt(i) - 'a']++;
            }
        }

        StringBuilder sb = new StringBuilder(str);

        for(int i = 0; i < str.length(); i++) {

            if(Character.isLowerCase(str.charAt(i))) {

                sb.setCharAt(i, getChar(array));
            }
        }
        return sb.toString();
    }

    private char getChar(int[] array) {

        while(count < 26 && array[count] == 0) {
            count ++;
        }

        array[count] --;
        return (char) ('a' + count);
    }

    public String sortLowerCase(String str) {

        if(str.length() == 0) {
            return str;
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < str.length(); i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                priorityQueue.add(str.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder(str);

        for(int i = 0; i < str.length(); i++) {

            if(Character.isLowerCase(str.charAt(i))) {
                sb.setCharAt(i, priorityQueue.poll());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        SortLowerCaseCharacter sortLowerCaseCharacter = new SortLowerCaseCharacter();
        Assert.assertEquals(sortLowerCaseCharacter.sortLowerCase("Google Test@123"), "Geeglo Tost@123");
    }
}
