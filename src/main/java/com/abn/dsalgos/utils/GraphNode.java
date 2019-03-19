package com.abn.dsalgos.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphNode<T>{

    private T id;
    private Integer weight;

    public GraphNode(T id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    public GraphNode(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        GraphNode<T> graphNode = (GraphNode) object;
        return graphNode.id == id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
