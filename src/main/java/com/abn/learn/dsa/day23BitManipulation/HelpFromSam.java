package com.abn.learn.dsa.day23BitManipulation;

/*
Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for
doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want
to take much help from Sam.

Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.
Input: 5
o/p: 2

Explanation:
Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Alex solves a question, score : 4
Takes help from Sam, score: 5

Input = 3
o/p: 2
Explanation:

Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Takes help from Sam, score : 3

Input:7
o/p: 3

Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Takes help from Sam, score : 3
Alex solves a question: 6
Takes help from Sam, score: 7

Represent Score in binary

5: 000101
3: 000011
7: 000111
8: 001000

Count set bits

 */
public class HelpFromSam {

    public int solve(int n) {
        int count = 0;
        while(n>0) {
            if((n & 1) > 0) {
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        HelpFromSam helpFromSam = new HelpFromSam();
        helpFromSam.solve(5);
    }
}
