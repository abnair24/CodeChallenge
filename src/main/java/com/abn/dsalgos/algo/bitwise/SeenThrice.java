package com.abn.dsalgos.algo.bitwise;

public class SeenThrice {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    public static void main(String[] args) {

        SeenThrice seenThrice = new SeenThrice();
        seenThrice.singleNumber(new int[] {2,2,2});
    }
}
