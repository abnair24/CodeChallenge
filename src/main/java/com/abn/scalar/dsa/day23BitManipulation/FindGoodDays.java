package com.abn.scalar.dsa.day23BitManipulation;

/*
Alex has a cat named Boomer. He decides to put his cat to the test for eternity.

He starts on day 1 with one stash of food unit, every next day, the stash doubles.

If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.

Boomer receives a net worth of A units of food. What is the number of days she received the stash?

Input 1:
A = 5
Output 1:
 2

Input 2:
A = 8
Output 2:
1

Explanation 1:

To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.

Explanation 2:

To eat a total of 8 units of food, Boomer behaved normally only on day 4.

*/

public class FindGoodDays {

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
        FindGoodDays findGoodDays = new FindGoodDays();
        findGoodDays.solve(8);
    }
}
