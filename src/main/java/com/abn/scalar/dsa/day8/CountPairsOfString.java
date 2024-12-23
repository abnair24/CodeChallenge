package com.abn.scalar.dsa.day8;

/*
Given a string S, Calculate number of pairs(i, j) such that  i<j and s[i] ='a' and s[j]='g'
 */
public class CountPairsOfString {

    public int solve(String s) {
        int pairCount = 0;
        int aCount = 0;

        for(char ch : s.toCharArray()) {

            if(ch == 'a') {
                aCount ++;
            } else if( ch == 'g') {
                pairCount = pairCount + aCount;
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {

        CountPairsOfString countPairsOfString = new CountPairsOfString();
        System.out.println(countPairsOfString.solve("gacgdgaga"));
        System.out.println(countPairsOfString.solve("baagdcag"));
    }
}
