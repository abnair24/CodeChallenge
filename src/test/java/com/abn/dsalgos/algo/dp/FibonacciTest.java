package com.abn.dsalgos.algo.dp;


import org.testng.annotations.Test;

public class FibonacciTest {

    Fibonacii fib = new Fibonacii();

    @Test
    public void topDownTest() {
        System.out.println(fib.fibTopDown(10));
    }

    @Test
    public void bottomUpTest() {
        System.out.println(fib.fibBottomUp(10));
    }
}
