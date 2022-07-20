package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    List<String> result = new LinkedList<>();

    public List<String> parenthesis(int n) {

        backtrack(n, 0, 0, new StringBuilder());
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

    public static void main(String[] args) {

        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        generateParenthesis.parenthesis(2);
    }
}
