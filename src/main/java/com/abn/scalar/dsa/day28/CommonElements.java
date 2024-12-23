package com.abn.scalar.dsa.day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElements {

    public int[] solve(int[] A, int[] B) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for(int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i])){
                list.add(B[i]);
                int count = map.get(B[i])- 1;
                if(count == 0) {
                    map.remove(B[i]);
                } else {
                    map.put(B[i], map.get(B[i])-1);
                }
            }
        }

        int[] result = list.stream().mapToInt(i->i).toArray();
        return result;
    }

    public static void main(String[] args) {
        CommonElements commonElements = new CommonElements();
        commonElements.solve(new int[]{1, 2, 2, 1}, new int[]{2, 3, 1, 2});
    }
}
