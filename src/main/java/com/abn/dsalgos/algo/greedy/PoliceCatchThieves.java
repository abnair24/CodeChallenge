package com.abn.dsalgos.algo.greedy;

/*
Given a number of police officers and thieves, calculate the maximum number of thieves that can be caught.
The input is an array in which each element contains either a police officer (P) or a thief (T).

Each police officer can catch only 'one' thief, and a police officer cannot catch a thief who is more than 'k' units away from him.

Eg:
 1. {'P', 'T', 'T', 'P', 'T'}, k = 1
    output = 2
 */

import java.util.ArrayList;
import java.util.List;

public class PoliceCatchThieves {

    public int getThiefCount(char[] array, int k) {
        int count = 0;

        List<Integer> thievesIndexes = new ArrayList<>();
        List<Integer> policeIndexes = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'T') {
                thievesIndexes.add(i);
            } else {
                policeIndexes.add(i);
            }
        }

        int ti = 0;
        int pi = 0;
        while (ti < thievesIndexes.size() && pi < policeIndexes.size()) {
            if (Math.abs(thievesIndexes.get(ti) - policeIndexes.get(pi)) <= k) {
                ti++;
                pi++;
                count++;
            } else if (thievesIndexes.get(ti) < policeIndexes.get(pi)) {
                ti++;
            } else {
                pi++;
            }
        }
        return count;
    }
}
