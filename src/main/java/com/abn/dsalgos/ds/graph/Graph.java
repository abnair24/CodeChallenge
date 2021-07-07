package com.abn.dsalgos.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
        0 --- 1
        |   /
        |  /
        2 ------3

        0 -  1 -> 2
        1 -  2
        2 -  3
 */

public class Graph {

    private int vertices;
    private LinkedList<Integer>[] adjacentList; // array of LinkedList to store the connections of each node

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacentList = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacentList[source].add(destination);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdjacentList() {
        return this.adjacentList;
    }
}


