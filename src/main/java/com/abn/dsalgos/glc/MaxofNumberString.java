package com.abn.dsalgos.glc;

import java.util.PriorityQueue;

public class MaxofNumberString {

    public String maxNumber(String s1, String s2) {

        if(s1.equals(s2)) {
            return s1;
        }

        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>((n1, n2) -> n2 - n1);
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((n1, n2) -> n2 - n1);

       for(char c1 : s1.toCharArray()) {

           maxHeap1.add(Character.getNumericValue(c1));
       }

       for(char c2 : s2.toCharArray()) {
           maxHeap2.add(Character.getNumericValue(c2));
       }

       if(maxHeap1.size() > maxHeap2.size()) {
           return getMaxNumber(maxHeap1);
       } else if(maxHeap2.size() > maxHeap1.size()) {
           return getMaxNumber(maxHeap2);
       }

       if(maxHeap1.peek() > maxHeap2.peek()) {
           return getMaxNumber(maxHeap1);
       } else if(maxHeap1.peek() < maxHeap2.peek()) {
           return getMaxNumber(maxHeap2);
       } else {
           return getMaxFromHeaps(maxHeap1, maxHeap2);
       }
    }

    private String getMaxNumber(PriorityQueue<Integer> maxHeap) {

       StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {

            sb.append(maxHeap.poll());
        }

        return sb.toString();
    }

    private String getMaxFromHeaps(PriorityQueue<Integer> maxHeap1, PriorityQueue<Integer> maxHeap2) {

        StringBuilder sb = new StringBuilder();

        while(!maxHeap1.isEmpty() && !maxHeap2.isEmpty()) {

            if(maxHeap1.peek() == maxHeap2.peek()) {
                sb.append(maxHeap1.poll());
                maxHeap2.poll();
            } else if (maxHeap1.peek() > maxHeap1.peek()){
                return sb + getMaxNumber(maxHeap1);
            } else {
                return sb + getMaxNumber(maxHeap2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        MaxofNumberString maxofNumberString = new MaxofNumberString();

        System.out.println(maxofNumberString.maxNumber("6328", "8563"));
        System.out.println(maxofNumberString.maxNumber("5550","5505"));
        System.out.println(maxofNumberString.maxNumber("11103", "1234"));
        System.out.println(maxofNumberString.maxNumber("555","555"));
    }
}
