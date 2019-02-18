package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    public void test1() throws Exception {
        Assert.assertTrue(anagram.isAnagram("TEMPLE","EEMTPL"));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertTrue(anagram.isAnagram("William Shakespeare","I am a weakish speller"));
    }
}
