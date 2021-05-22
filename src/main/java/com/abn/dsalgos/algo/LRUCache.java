package com.abn.dsalgos.algo;

import java.util.HashMap;
import java.util.Map;

class Node {

    public Node previous;
    public Node next;
    public int key;
    public int value;

}

public class LRUCache {

    private final Map<Integer, Node> hmap;
    private Node start, end;
    private final int size;

    public LRUCache(int size) {
        hmap = new HashMap<>();
        this.size = size;
    }

    public int getNode(int key) {
        if(hmap.containsKey(key)) {
            Node node = hmap.get(key);
            remove(node);
            addAtCacheTop(node);
            return node.value;
        }

        return -1;
    }

    public void putNode(int key, int value) {
        if(hmap.containsKey(key)) {
            Node node = hmap.get(key);
            node.value = value;
            remove(node);
            addAtCacheTop(node);
        } else {
            Node newNode = new Node();
            newNode.previous = null;
            newNode.next = null;
            newNode.key = key;
            newNode.value = value;

            if(hmap.size() >= size) {
                hmap.remove(end.key);
                remove(end);
            }
            addAtCacheTop(newNode);
            hmap.put(key, newNode);
        }
    }

    private void addAtCacheTop(Node node) {
        node.next = start;
        node.previous = null;
        if(start != null) {
            start.previous = node;
        }
        start = node;

        if(end == null) {
            end = start;
        }
    }

    private void remove(Node node) {

        if(node.previous != null) {
            node.previous.next = node.next;
        } else {
            start = node.next;
        }

        if(node.next != null) {
            node.next.previous = node.previous;
        } else {
            end = node.previous;
        }
    }
}
