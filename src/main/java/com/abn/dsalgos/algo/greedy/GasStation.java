package com.abn.dsalgos.algo.greedy;

/*
There are n gas stations along a circular route, where the amount of gas at the
ith station is gas[i].We have a car with an unlimited gas tank, and it costs cost[i] of gas to travel from the ith
station to the next i+1 th station. We begin the journey with an empty tank at one of the gas stations.
Find the index of the gas station in the integer array gas such that if we start from that index we may
return to the same index by traversing through all the elements, collecting gas[i] and consuming cost[i].

If it is not possible, return -1.

If there exists such index, it is guaranteed to be unique.


Gas : {1, 2, 3, 4, 5}
Cost : {3, 4, 5, 1, 2}

o/p: index: 3

G: {1, 2, 3, 3}
C: {2, 1, 5, 1}

O/P: index: 3

G: {2, 3, 4}
C: {3, 4, 3}

O/P: index : -1
 */
public class GasStation {

    public int solve(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int index = 0;

        while(index < gas.length) {
            totalGas += gas[index];
            totalCost += cost[index];
            index ++;
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int startIndex = 0;
        int currentGas = 0;

        for(int i = 0; i < gas.length; i++) {

            currentGas = currentGas + gas[i] - cost[i];

            if(currentGas < 0) {
                currentGas = 0;
                startIndex = i + 1;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {

        GasStation gasStation = new GasStation();
        System.out.println(gasStation.solve(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        System.out.println(gasStation.solve(new int[] {1, 2, 3, 3}, new int[] {2, 1, 5, 1}));
        System.out.println(gasStation.solve(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
    }
}
