package com.abn.design.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {

    public Node previous;
    public Node next;
    public int key;
    public int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {

        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

            if (map.size() > capacity) {
                Node lru = removeTailNode();
                map.remove(lru.key);
            }
        }
    }

    public void removeNode(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTailNode() {
        Node lru = tail.previous;
        removeNode(lru);
        return lru;
    }
}

