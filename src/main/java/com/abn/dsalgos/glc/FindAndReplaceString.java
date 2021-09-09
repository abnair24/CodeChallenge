package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations
are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement
will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of
each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the
"ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.

Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"

Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
 */

public class FindAndReplaceString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int sourceLen = 0;

        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();

        for(int i = 0; i< sources.length; i ++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        Arrays.sort(indices);

        StringBuilder sb = new StringBuilder(s);

        for(int i = indices.length -1; i >= 0; i --) {

            int index = indices[i];

            String sourceStr = sourceMap.get(index);
            String targetStr = targetMap.get(index);

            sourceLen = sourceStr.length();

            if(s.substring(index,sourceLen + index).equals(sourceStr)) {
                sb.replace(index, sourceLen + index, targetStr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "vmokgggqzp";
        int[] indices = {3,5,1};
        String[] sources = {"kg","ggq","mo"};
        String[] target = {"s","so","bfr"};

        String expected = "vbfrssozp";

        Assert.assertEquals(new FindAndReplaceString().findReplaceString(s, indices, sources, target), expected);
    }
}
