//package com.abn.design.leetcode;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.List;
//import java.util.Stack;
//
//public class SecurityPolicyChecker {
//
//    /**
//     * Parses an Okta routing policy string. Validates syntax and extracts the deepest sub-expression.
//     * @param expression The raw string policy to validate and parse.
//     * @return The inner-most core expression string.
//     */
//    public List<String> parseAndExtractDeepest(String expression) {
//        if (expression == null || expression.isEmpty()) {
//            return List.of();
//        }
//
//        // --- Pass 1: validate + find maxDepth ---
//        Deque<Integer> stack = new ArrayDeque<>();
//        int maxDepth = 0;
//        int depth = 0;
//
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (c == '(') {
//                stack.push(i);
//                depth++;
//                maxDepth = Math.max(maxDepth, depth);
//            } else if (c == ')') {
//                if (stack.isEmpty()) throw new IllegalArgumentException(
//                        "Unbalanced closing bracket at index " + i);
//                stack.pop();
//                depth--;
//            }
//        }
//        if (!stack.isEmpty()) throw new IllegalArgumentException(
//                "Unbalanced opening bracket(s) remain unclosed.");
//        // --- Pass 2: collect every substring that sits at maxDepth ---
//        List<String> results = new ArrayList<>();
//        depth = 0;
//        int start = -1;
//
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (c == '(') {
//                depth++;
//                if (depth == maxDepth) start = i;  // entered a maxDepth group
//            } else if (c == ')') {
//                if (depth == maxDepth && start != -1) {
//                    results.add(expression.substring(start + 1, i).trim());
//                    start = -1;
//                }
//                depth--;
//            }
//        }
//
//        return results;
//
//    }
//
//    public static void main(String[] args) {
//        com.abn.dsalgos.algo.twoPointers.SecurityPolicyChecker parser = new com.abn.dsalgos.algo.twoPointers.SecurityPolicyChecker();
//
//        // Example Happy Path
//        String validPolicy = "((Group == 'Eng') AND (Location == 'US') AND (((device == 'iPhone'))) AND (((OS == 'iOS'))))";
//        System.out.println("Deepest Rule Found: " + parser.parseAndExtractDeepest(validPolicy));
//        // Output: Group == 'Eng'
//
//        // Example Error Path (Unbalanced)
//        try {
//            String brokenPolicy = "((Group == 'Eng')";
//            parser.parseAndExtractDeepest(brokenPolicy);
//        } catch (IllegalArgumentException e) {
//            System.out.println("\nCaught expected framework error: " + e.getMessage());
//            // Output: Malformed policy: Unbalanced opening bracket(s) remain unclosed.
//        }
//    }
//}
