package com.abn.scalar.dsa.day17;

/*
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
 */

public class CountOccurance {

    public int solve(String str) {

        String s = "bob";
        int count = 0;

        int len = str.length() - s.length();
        for(int i = 0; i <= len; i++) {

            if(str.charAt(i) == s.charAt(0)) {
                if(str.substring(i, i + s.length()).equals(s)) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountOccurance countOccurance = new CountOccurance();
        System.out.println(countOccurance.solve("abobc"));
        System.out.println(countOccurance.solve("bobob"));
    }
}