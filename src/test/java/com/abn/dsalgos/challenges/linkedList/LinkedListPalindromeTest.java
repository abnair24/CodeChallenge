package com.abn.dsalgos.challenges.linkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListPalindromeTest {

    LinkedListPalindrome<Integer> list;
    LinkedListPalindrome<Character>charList;


    @BeforeMethod
    public void setup() throws Exception {
        list = new LinkedListPalindrome<>();
        charList = new LinkedListPalindrome<>();
    }

    @Test
    public void palindromeTest() throws Exception {
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);

        Assert.assertTrue(list.isPalindrome());
    }

    @Test
    public void palindromeCharacter() throws Exception {
        charList.insertFirst('m');
        charList.insertLast('a');
        charList.insertLast('l');
        charList.insertLast('a');
        charList.insertLast('y');
        charList.insertLast('a');
        charList.insertLast('l');
        charList.insertLast('a');
        charList.insertLast('m');

        Assert.assertTrue(charList.isPalindrome());
    }
}
