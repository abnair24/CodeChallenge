package com.abn.dsalgos.dailyCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SumOfLiskisK {

    public List<Integer> sumOfListIsK(int[] array,int k) throws Exception {
        int length = array.length;

        HashSet<Integer> hm = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<length;i++) {
            if(hm.contains(k-array[i])) {
                System.out.println(array[i] + ":" + (k-array[i]));
            } else {
                hm.add(array[i]);
            }
        }
        return list;
    }
}
