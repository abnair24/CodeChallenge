package com.abn.learn.dsa.day27;

public class GCDofArray {

    public int solve(int[] array) {

        int ans = array[0];
        for(int i = 1; i < array.length; i++) {
            ans = gcd(ans, array[i]);
        }
        return ans;
    }

    private int gcd(int num1, int num2) {

        if (num1 == 0 && num2 == 0) {
            return 0;
        }

        if (num1 == 0) {
            return num2;
        }

        if (num2 == 0) {
            return num1;
        }

        if (num1 == num2) {
            return num1;
        }

        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        } else {
            return gcd(num1, num2 - num1);
        }
    }

    public static void main(String[] args) {

        GCDofArray gcDofArray = new GCDofArray();

        System.out.println(gcDofArray.solve(new int[] {21, 35, 42, 100}));
    }
}
