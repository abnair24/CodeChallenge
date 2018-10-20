package com.abn.dsalgos.challenges.stack;

import com.abn.dsalgos.challenges.SortStack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortStackTest {

    Stack<Integer> s1 = new Stack<>();
    SortStack sortStack;

    @BeforeMethod
    public void setup() throws Exception {
        s1.push(1);
        s1.push(2);
        s1.push(8);
        s1.push(6);
        s1.push(7);
        s1.push(10);
        s1.push(5);
    }


    @Test
    public void sortStack() throws Exception {
        sortStack = new SortStack();
        sortStack.sort(s1);

        List<Integer> list = new ArrayList<>(s1);

        for(Integer i : list) {
            System.out.println(i+", ");
        }
    }
}
