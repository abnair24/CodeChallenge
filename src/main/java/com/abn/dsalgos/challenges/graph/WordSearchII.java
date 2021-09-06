package com.abn.dsalgos.challenges.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (String word : words) {
            Trie current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new Trie());
                current = current.children.get(ch);
            }
            current.word = word;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (root.children.containsKey(board[i][j])) {
                    matrixHelper(board, i, j, rows, cols, root, visited);
                }
            }
        }
        return result;
    }

    private void matrixHelper(char[][] board, int i, int j, int m, int n, Trie root, boolean[][] visited) {

        Trie currentNode = root.children.get(board[i][j]);

        visited[i][j] = true;

        if (currentNode.word != null) {
            result.add(currentNode.word);
            currentNode.word = null;
        }

        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x > -1 && y > -1 && x < m && y < n &&
                    currentNode.children.containsKey(board[x][y]) && !visited[x][y]) {
                matrixHelper(board, x, y, m, n, currentNode, visited);
            }
        }

        visited[i][j] = false;
        if (currentNode.children.isEmpty()) {
            root.children.remove(board[i][j]);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] input = {"oath", "pea", "eat", "rain"};

        WordSearchII wordSearchII = new WordSearchII();
        wordSearchII.findWords(board, input);
    }
}

class Trie {
    Map<Character, Trie> children;
    String word = null;

    public Trie() {
        children = new HashMap<>();
    }
}
