package com.abn.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListConcurrency {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

       // List<Integer> synchonized = Collections.synchronizedList(list);

        list.add(10);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add(30);
        }
    }
}
