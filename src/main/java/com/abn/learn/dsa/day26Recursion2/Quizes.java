package com.abn.learn.dsa.day26Recursion2;

public class Quizes {

    public void solve(int N) {
        if(N == 0) {
            return;
        }
        System.out.println(N);
        solve(N-1);
        System.out.println(N);

    }

    public void solve1(int N) {
        if(N == 0) {
            return;
        }

        System.out.println(N);
        solve(N - 1);
    }

    public static void main(String[] args) {
        Quizes test = new Quizes();
        test.solve(3);

        //stackoverflow
       // test.solve1(-3);
    }
}
