package com.abn.scalar.dsa.day50;

import java.util.ArrayList;

/*
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

A = 3
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class GenerateAllParenthesisII {

    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int A) {

        backtrack(A, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int leftBracket, int rightBracket, StringBuilder sb) {

        if(sb.length() == n*2 && leftBracket == n && rightBracket == n) {
            result.add(sb.toString());
            return;
        }

        if(leftBracket < n){
            sb.append("(");
            backtrack(n, leftBracket+1, rightBracket, sb);
            sb.setLength(sb.length() - 1);
        }

        if(rightBracket < leftBracket) {
            sb.append(")");
            backtrack(n, leftBracket, rightBracket + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
