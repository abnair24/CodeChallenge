package com.abn.scalar.dsa.day32;

import java.util.ArrayList;
import java.util.Collections;

/*
You are developing a feature for Zomato that helps users find the nearest restaurants to their current location.
It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of
coordinates in a two-dimensional space representing their geographical location on a map.
The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map),
and an integer B representing the number of closest restaurants to the user. The user's current location is assumed
to be at the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).
 */
public class BclosestPointsToOrigin {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A, (a, b) -> {
            int x = (a.get(0) * a.get(0)) + (a.get(1) * a.get(1));
            int y = (b.get(0) * b.get(0)) + (b.get(1) * b.get(1));

            return Integer.compare(x, y);
        });
        return new ArrayList<>(A.subList(0, B));
    }
}
