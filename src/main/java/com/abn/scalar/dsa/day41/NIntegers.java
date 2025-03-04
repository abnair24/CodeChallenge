package com.abn.scalar.dsa.day41;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.


NOTE: All the A integers will fit in 32-bit integers.

Input 1:

 A = 3
Input 2:

 A = 7


Example Output

Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]
 */
public class NIntegers {

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A <= 3) {
            for(int i = 0; i < A; i ++) {
                list.add(i + 1);
            }
        } else {
            Queue<Integer> queue = new LinkedList<>();
            int index = 3;
            queue.add(1);
            queue.add(2);
            queue.add(3);
            list.add(1);
            list.add(2);
            list.add(3);

            while(index < A) {
                int current = queue.peek();
                int num = current * 10 + index % 3 + 1;

                queue.add(num);
                list.add(num);

                if(index % 3 == 2) {
                    queue.poll();
                }
                index ++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        NIntegers nIntegers = new NIntegers();
        System.out.println(nIntegers.solve(20));
    }
}
