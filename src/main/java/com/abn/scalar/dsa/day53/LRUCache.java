package com.abn.scalar.dsa.day53;

import java.util.HashMap;
import java.util.Map;

class LRUListNode {

    int val;
    int key;
    LRUListNode next;
    LRUListNode prev;

    LRUListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    LRUListNode head = new LRUListNode(0, 0);
    LRUListNode tail = new LRUListNode(0, 0);

    Map<Integer, LRUListNode> map = new HashMap<>();

    int size;

    public LRUCache(int size) {
        this.size = size;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            LRUListNode current = map.get(key);
            remove(current);
            insert(current);
            return current.val;
        }

        return -1;
    }

    public void set(int key, int value) {

        if(map.containsKey(key)) {

            remove(map.get(key));
        }
        if(map.size() == size) {
            remove(tail.prev);
        }

        insert(new LRUListNode(key, value));
    }

    public void remove(LRUListNode node) {

        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(LRUListNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        lruCache.set(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.set(1, 1);
        lruCache.set(4, 1);
        System.out.println(lruCache.get(2));
    }
}
