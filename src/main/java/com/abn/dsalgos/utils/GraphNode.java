package com.abn.dsalgos.utils;

import java.util.Objects;

public class GraphNode<T> {

    public T data;
    public Integer weight;
    public boolean visited;

    public GraphNode(T data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    public GraphNode(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return Objects.equals(data, graphNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "data:" + data;
    }
}
