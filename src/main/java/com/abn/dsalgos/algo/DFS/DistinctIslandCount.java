package com.abn.dsalgos.algo.DFS;

import java.util.HashSet;
import java.util.Set;

public class DistinctIslandCount {

    public int islandCount(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> paths = new HashSet<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    StringBuilder path = new StringBuilder();
                    dfsHelper(matrix, visited, i,j, path, 'S');
                    paths.add(path.toString());
                }
            }
        }
        for(String path : paths) {
            System.out.println(path);
        }

        return paths.size();
    }

    private void dfsHelper(int[][] matrix, boolean[][] visited, int r, int c, StringBuilder path, char ch) {

        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || matrix[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        path.append(ch);

        dfsHelper(matrix, visited, r-1, c, path, 'U');
        dfsHelper(matrix, visited, r+1, c, path, 'D');
        dfsHelper(matrix, visited, r, c-1, path, 'L');
        dfsHelper(matrix, visited, r, c+1, path, 'R');

        path.append('B');
    }

    public static void main(String[] args) {

        DistinctIslandCount distinctIslandCount = new DistinctIslandCount();
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}
        };
        System.out.println(distinctIslandCount.islandCount(matrix));
    }
}
