package com.abn.dsalgos.algo.bitwise;

public class SeenThrice {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice

//            System.out.println(~0 & 2);

            System.out.println(~5 & 5);



            System.out.println(seenOnce ^ num);
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
