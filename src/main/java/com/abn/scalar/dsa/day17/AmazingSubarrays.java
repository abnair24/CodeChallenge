package com.abn.scalar.dsa.day17;

/*
You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input: Only argument given is string S.
Output : Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.

ABEC: 6

Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */

public class AmazingSubarrays {

    public int solve(String str) {

        int len = str.length();
        int count = 0;

        for(int i = 0; i < len; i++) {

            char ch = str.charAt(i);

            if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch =='i'|| ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u') {

                count += (len - i);
                count %= 10003;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AmazingSubarrays amazingSubarrays = new AmazingSubarrays();
        System.out.println(amazingSubarrays.solve("ABEC"));
    }
}