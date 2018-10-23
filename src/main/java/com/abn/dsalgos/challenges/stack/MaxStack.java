package com.abn.dsalgos.challenges.stack;

import java.util.Stack;

class Wrapper{
    int data;
    int maxData;

    public Wrapper(int data, int maxData) {
        this.data = data;
        this.maxData = maxData;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getMaxData() {
        return maxData;
    }

    public void setMaxData(int maxData) {
        this.maxData = maxData;
    }
}

public class MaxStack {

    private Stack<Wrapper> stack=new Stack<>();

    public void insert(int data) {
        int max= stack.isEmpty()? data : data>getMaxData() ? data : getMaxData();
        stack.push(new Wrapper(data,max));
    }

    public int getMaxData() {
        return stack.peek().getMaxData()  ;
    }

    public int pop() {
        return stack.pop().getData();
    }
}
