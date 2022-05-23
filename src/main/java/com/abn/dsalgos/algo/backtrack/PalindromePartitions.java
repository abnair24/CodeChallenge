package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitions {
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> partition(String s) {

        LinkedList<String> track = new LinkedList<>();
        helper(s, track,0);

        return result;
    }

    private void helper(String s, LinkedList<String> track, int start) {

        if(start >= s.length()) {
            System.out.println(track);
            result.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i < s.length(); ++i) {
            if(isPalindrome(s, start, i)) {
                track.add(s.substring(start, i + 1));
                helper(s, track, i + 1);
                track.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right)
            if(s.charAt(left) != s.charAt(right)) {
                left ++;
                right --;
                return false;
            }

        return true;
    }

    public static void main(String[] args) {

        new PalindromePartitions().partition("aabcd");
    }
}
