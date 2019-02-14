package com.abn.dsalgos.challenges.dp;


import org.testng.annotations.Test;

public class FibonacciTest {

    Fibonacii fib = new Fibonacii();

    @Test
    public void topDownTest() throws Exception {
        System.out.println(fib.fibTopDown(10));
    }

    @Test
    public void bottomUpTest() throws Exception {
        System.out.println(fib.fibBottomUp(10));
    }
}
