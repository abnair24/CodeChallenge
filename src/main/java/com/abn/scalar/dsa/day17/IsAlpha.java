package com.abn.scalar.dsa.day17;

/*
check for isalphabetic
 */

public class IsAlpha {

    public int solve(char[] array) {

        if(array.length == 0) {
            return 0;
        }

        for(char ch : array) {
            if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        IsAlpha isAlpha = new IsAlpha();
        System.out.println(isAlpha.solve(new char[] {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'}));

        System.out.println(isAlpha.solve(new char[] {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'}));
    }
}