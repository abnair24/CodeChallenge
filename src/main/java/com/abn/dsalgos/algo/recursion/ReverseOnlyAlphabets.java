package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;

/*
You are given a string that contains alphabetical characters (a - z, A - Z)
and some other characters ($, !, etc.). For example, one input may be:

B!FDCEA2 => A!ECDFB2

sea!$hells3 => sll!$ehaes3

7_28] => 7_28]
 */
public class ReverseOnlyAlphabets {

    public static void main(String[] args) {

        ReverseOnlyAlphabets reverseOnlyAlphabets = new ReverseOnlyAlphabets();
        Assert.assertEquals(reverseOnlyAlphabets.reverse("B!FDCEA2"), "A!ECDFB2");
        Assert.assertEquals(reverseOnlyAlphabets.reverse("sea!$hells3"), "sll!$ehaes3");
        Assert.assertEquals(reverseOnlyAlphabets.reverse("7_28]"), "7_28]");
    }

    public String reverse(String str) {

        int len = str.length();
        int start = 0;
        int end = len - 1;

        StringBuilder sb = new StringBuilder(str);

        while (start < end) {

            while (!Character.isLetter(str.charAt(start)) && start < end) {
                sb.setCharAt(start, str.charAt(start));
                start++;
            }

            while (!Character.isLetter(str.charAt(end)) && end > start) {
                sb.setCharAt(end, str.charAt(end));
                end--;
            }

            sb.setCharAt(start, str.charAt(end));
            sb.setCharAt(end, str.charAt(start));
            start++;
            end--;
        }
        return sb.toString();
    }
}
