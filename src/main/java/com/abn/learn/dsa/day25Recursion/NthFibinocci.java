package com.abn.learn.dsa.day25Recursion;

public class NthFibinocci {

    public int solve(int N) {
        if(N < 2) {
            return N;
        }

        return solve(N-1) + solve(N-2);
    }

    public static void main(String[] args) {

        NthFibinocci nthFibinocci = new NthFibinocci();
        System.out.println(nthFibinocci.solve(8));
    }
}
