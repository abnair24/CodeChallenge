package com.abn.learn.dsa.day25Recursion;

/*
Given N, print all from N to 1
 */
public class WhirlpoolCountDown {

    public void decrement(int N) {
        if(N == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(N);
        decrement(N-1);
    }

    public static void main(String[] args) {

        WhirlpoolCountDown whirlpoolCountDown = new WhirlpoolCountDown();
        whirlpoolCountDown.decrement(5);
    }
}
