package com.abn.dsalgos.algo;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final Map<Integer, Integer> keyFrequencyMap;
    private final Map<Integer, Integer> keyValueMap;
    private final Map<Integer, LinkedHashSet<Integer>> frequencyMap;

    int size;
    int min;

    public LFUCache(int size) {
        this.size = size;
        this.keyFrequencyMap = new HashMap<>();
        this.keyValueMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.frequencyMap.put(1, new LinkedHashSet<>());
        this.min = 0;
    }

    public int getKey(int key) {
        if(size <= 0 || keyValueMap.get(key) == null) {
            return -1;
        }

        int oldFrequency = keyFrequencyMap.get(key);
        int newFrequency = oldFrequency + 1;
        keyFrequencyMap.put(key, newFrequency);
        frequencyMap.get(oldFrequency).remove(key);

        if(oldFrequency == min && frequencyMap.get(oldFrequency).size() == 0) {
            min ++;
        }

        if(!frequencyMap.containsKey(newFrequency)) {
            frequencyMap.put(newFrequency, new LinkedHashSet<>());
        }

        frequencyMap.get(newFrequency).add(key);
        return keyValueMap.get(key);
    }

    public void putKey(int key, int value) {

        if(keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            getKey(key);
            return;
        }

        if(keyValueMap.size() >= size) {
            if(frequencyMap.get(min) != null) {
                int oldkey = frequencyMap.get(min).iterator().next();
                frequencyMap.get(min).remove(oldkey);
                keyFrequencyMap.remove(oldkey);
                keyValueMap.remove(oldkey);
            }
        }

        keyValueMap.put(key, value);
        keyFrequencyMap.put(key, 1);
        min = 1;
        frequencyMap.get(min).add(key);
    }
}
