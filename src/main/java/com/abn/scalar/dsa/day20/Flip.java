package com.abn.scalar.dsa.day20;

import java.util.ArrayList;

/*
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
By flipping, we mean changing character 0 to 1 and vice-versa.


Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
 If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Example Input

Input 1:

A = "010"
Input 2:

A = "111"


Example Output

Output 1:

[1, 1]
Output 2:

[]

 */
public class Flip {

    public ArrayList<Integer> flip(String array) {

        ArrayList<Integer> res = new ArrayList<>();

        int originalOnesCount = 0;

        for (int i = 0; i < array.length(); i++) { // Calculating total number of ONES
            if (array.charAt(i) == '1') {
                originalOnesCount++;
            }
        }
        if (originalOnesCount == array.length()) {
            return res;
        }

        int maxCount = 0, count = 0, l = 0, r = 0;
        int minl = 0, minr = 0;
        for (int i = 0; i < array.length(); i++) {
            if (array.charAt(i) == '0') {         // If 0 increse the count
                count++;
            } else {
                count--;                    // If 1 decrease the count
            }
            if (maxCount < count) {           // If max is lesser update it and store the index pairs
                maxCount = count;
                minl = l;
                minr = r;
            }
            if (count < 0) {                    // If count reaches -ve reset it to 0 and start the l,r from that particular index
                count = 0;
                l = i + 1;               // +1 Because of 1 based indexing
                r = i + 1;               // +1 Because of 1 based indexing
            } else {                           // If count is non negative just increase r index pointer
                r++;
            }

        }
        res.add(minl + 1);
        res.add(minr + 1);
        return res;
    }

    public static void main(String[] args) {

        Flip flip = new Flip();
        System.out.println(flip.flip("010"));
    }
}
