package com.abn.learn.dsa.day23BitManipulation;

/*
O<=A,B,C,<=20 A zeros followedby B ones followedby 0 zeros
Return the number

A =4, B= 3, C=2

            0 0 0 0 1 1 1 0 0:
Index:      8 7 6 5 4 3 2 1 0


Approach: Set bits starts from C index and ends at B+C -1 index.
left shift one by C, C+1 ... C+B -1 times.

Alternate

Power of 2
8: (01000)       7: (00111)
2: (00010)       1: (00001)
4: (00100)       3: (00011)
16 (10000)      15: (01111)

B= 3, 111, 2^3 - 1-> 111

(2^B - 1) << C

 */
public class NumberFormation {

    public long solve(int A, int B, int C) {

        long ans = 0;
        for(int i = C; i <= B+C-1; i++) {
            ans = ans | (1 << i);
        }

        return ans;
    }

    /*
    Method 2
     */

    public long solve1(int A, int B, int C) {

      return ((1 << B) - 1) << C;

    }

    public static void main(String[] args) {

        NumberFormation numberFormation = new NumberFormation();
        System.out.println(numberFormation.solve(4, 3, 2));
        System.out.println(numberFormation.solve1(4, 3, 2));

    }
}
