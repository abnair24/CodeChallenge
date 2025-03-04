package com.abn.dsalgos.algo.greedy;

/*

You need to find the minimum number of refueling stops that a car needs to make to cover a distance, target.
For simplicity, assume that the car has to travel from west to east in a straight line.
There are various fuel stations on the way that are represented as a 2-D array of stations,
i.e., stations[i] =[di,fi], where di is the distance (in miles) of the ith gas station from the starting position,
and fi is the amount of fuel (in liters) that it stores. Initially, the car starts with k liters of fuel.
The car consumes one liter of fuel for every mile traveled. Upon reaching a gas station, the car can stop
and refuel using all the petrol stored at the station. If it cannot reach the target, the program returns −1.

Note: If the car reaches a station with 0 fuel left, it can refuel from that station, and all the fuel from that
 station can be transferred to the car. If the car reaches the target with 0 fuel left, it is still considered to have arrived.
 */

import java.util.PriorityQueue;

public class MinimumRefuelStops {

    public int solve(int[][] stations, int startFuel, int target) {
        if(startFuel >= target) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int maxDistance = startFuel;
        int i = 0;
        int stops = 0;
        int n = stations.length;

        while(maxDistance < target) {

            if(i < n && maxDistance >= stations[i][0]) {
                maxHeap.offer(stations[i][1]);
                i++;
            } else if(maxHeap.isEmpty()) {
                return -1;
            } else {
                maxDistance = maxDistance + maxHeap.poll();
                stops++;
            }
        }
        return stops;
    }

    public static void main(String[] args) {

        MinimumRefuelStops minimumRefuelStops = new MinimumRefuelStops();
        System.out.println(minimumRefuelStops.solve(new int[][] {
                {9, 12}, {11, 7}, {13, 16}, {21, 18}, {47, 6}, {53, 11}, {58, 5}
        }, 14, 59));
    }
}
