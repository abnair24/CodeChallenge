package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

Input: n = 2
Output: 91

Input: n = 0
Output: 1
 */
public class UniqueDigitNumbers {

    List<Integer> result = new LinkedList<>();
    public int countNumbersWithUniqueDigits(int n) {

        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return 10;
        }

        LinkedList<Integer> track = new LinkedList<>();
        int limit = 0;
        for(int i = 1; i <= n; i++) {
            limit = limit * 10 + 9;
        }
        for(int i = 1; i <= n; i ++) {
            backtrack(i, track, limit);
        }

        return result.size() + 1;
    }

    private void backtrack(int n, LinkedList<Integer> track, int limit) {

        if(track.size() == n) {
            int num = getNumber(track);
            if (num <= limit) {
                result.add(num);
            }
            return;
        }

        for(int i = 0; i <= 9;i++) {

            if(track.contains(i)) {
                continue;
            }

            if(track.isEmpty() && i == 0) {
                continue;
            }

            track.add(i);
            backtrack(n, track, limit);
            track.removeLast();
        }
    }

    private Integer getNumber(LinkedList<Integer> list) {

        int num = 0;
        for(int i = 0; i < list.size(); i++) {
            num = num * 10 + list.get(i);
        }

        return num;
    }

    public static void main(String[] args) {
        UniqueDigitNumbers uniqueDigitNumbers = new UniqueDigitNumbers();
        System.out.println(uniqueDigitNumbers.countNumbersWithUniqueDigits(3));
    }
}
