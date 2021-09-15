package com.abn.dsalgos.algo.backtrack;

/*
You are given a list of airline tickets where tickets[i] = [from(i), to(i)] represent
the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as
a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlightItinerary {

    Map<String, List<String>> flights;
    Map<String, boolean[]> isVisitedMap;

    LinkedList<String> result;
    int size;

    public List<String> findItinerary(List<List<String>> tickets) {

        flights = new HashMap<>();
        isVisitedMap = new HashMap<>();

        result = new LinkedList<>();

        for (List<String> ticket : tickets) {

            if (!flights.containsKey(ticket.get(0))) {
                List<String> destinationList = new LinkedList<>();
                destinationList.add(ticket.get(1));
                flights.put(ticket.get(0), destinationList);
            } else {
                List<String> destinationList = flights.get(ticket.get(0));
                destinationList.add(ticket.get(1));
            }
        }

        for (Map.Entry<String, List<String>> entry : flights.entrySet()) {
            Collections.sort(entry.getValue());
            isVisitedMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        size = tickets.size();
        LinkedList<String> routes = new LinkedList<String>();
        routes.add("JFK");

        backtrack("JFK", routes);
        return result;
    }

    private boolean backtrack(String origin, LinkedList<String> routes) {

        if (routes.size() == size + 1) {
            result = (LinkedList<String>) routes.clone();
            return true;
        }

        if (!flights.containsKey(origin)) {
            return false;
        }

        int i = 0;
        boolean[] isVisited = isVisitedMap.get(origin);

        for (String destination : flights.get(origin)) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                routes.add(destination);
                boolean status = backtrack(destination, routes);
                routes.pollLast();
                isVisited[i] = false;

                if (status) {
                    return true;
                }
            }
            ++i;
        }
        return false;
    }

    public static void main(String[] args) {
        FlightItinerary flightItinerary = new FlightItinerary();

        List<List<String>> input = new ArrayList<>();
        List<String> pair1 = new ArrayList<>();
//        pair1.add("JFK");
//        pair1.add("SFO");
        pair1.add("JFK");
        pair1.add("AAA");


        List<String> pair2 = new ArrayList<>();
//        pair2.add("JFK");
//        pair2.add("ATL");
        pair2.add("BBB");
        pair2.add("CCC");

        List<String> pair3 = new ArrayList<>();
//        pair3.add("SFO");
//        pair3.add("ATL");
        pair3.add("JFK");
        pair3.add("BBB");

        List<String> pair4 = new ArrayList<>();
//        pair4.add("ATL");
//        pair4.add("JFK");
        pair4.add("CCC");
        pair4.add("JFK");

//        List<String> pair5 = new ArrayList<>();
//        pair5.add("ATL");
//        pair5.add("SFO");

        input.add(pair1);
        input.add(pair2);
        input.add(pair3);
        input.add(pair4);
//        input.add(pair5);

        flightItinerary.findItinerary(input);
    }
}
