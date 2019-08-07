package com.abn.dsalgos.challenges.problems;


/*
Print the triangle Pattern (n = 3)

                 *
               *   *
             *   *   *


               *
            *     *
          *    *     *
       *    *     *     *

  Hint : Form a matrix and figure out rows and columns required.
 */


public class Pattern {
    public static void main(String[] args) {
        patternPrint(3);
    }

    public static void patternPrint(int n) {
        int col = n*2 -1;
        int row = n;

        for(int i =0; i< n; i++) {
            int count =0;
            for(int k = row - i; k > 1; k-- ){
                System.out.print(" ");
            }
            for(int j = col - row - i ; j < col&& count <= i; j+=2 ) {
                System.out.print("* ");
                count++;
            }
            System.out.println();
        }
    }
}
