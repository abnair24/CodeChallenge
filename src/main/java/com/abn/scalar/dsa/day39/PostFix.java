package com.abn.scalar.dsa.day39;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Evaluate postfix operation

4, 3, 3, *, +, 2, -
=> 3*3 = 9
=> 9 + 4 = 13
=> 13 - 2 = 11

 */
public class PostFix {

    public int solve(String[] array) {

        Stack<Integer> stack = new Stack<>();

        if(array.length == 0 || array.length == 1) {
            return Integer.parseInt(array[0]);
        }

        for(int i = 0; i < array.length; i++) {

            String current = array[i];

            if(!isOperator(current)) {
                stack.push(Integer.parseInt(current));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                char operator = current.charAt(0);
                int result = calculate(operand1, operand2, operator);
                stack.push(result);
            }
        }

        return stack.isEmpty() ? -1 : stack.peek();
    }

    private static boolean isOperator(String value){
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        return operators.contains(value);
    }

    private int calculate(int operand1, int operand2, char operator) {

        if(operator == '+') {
            return operand1 + operand2;
        } else if(operator == '-') {
            return operand1 - operand2;
        } else if(operator == '*') {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    public static void main(String[] args) {

        PostFix postFix = new PostFix();
        System.out.println(postFix.solve(new String[] {"5","1","2","+","4","*","+","3","-"}));
        System.out.println(postFix.solve(new String[] {"-500", "-10", "/"}));

    }
}
