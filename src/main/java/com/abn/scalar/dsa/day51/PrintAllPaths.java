package com.abn.scalar.dsa.day51;

import java.util.ArrayList;
import java.util.Collections;

/*
Input 1 :
A = 3 , B = 2
Input 2 :
A = 1 , B = 2


Example Output

Output 1 :
DDR DRD RDD
Output 2 :
R
 */
public class PrintAllPaths {

    public ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> paths = new ArrayList<>();

        findPaths(0, 0, A, B, "", paths);
        Collections.sort(paths);
        return paths;
    }

    public static void findPaths(int r, int c, int A, int B, String path, ArrayList<String> paths) {
        // Base case: If we reach the bottom-right corner
        if (r == A - 1 && c == B - 1) {
            paths.add(path);
            return;
        }

        // Move Down
        if (r < A - 1) {
            findPaths(r + 1, c, A, B, path + "D", paths);
        }

        // Move Right
        if (c < B - 1) {
            findPaths(r, c + 1, A, B, path + "R", paths);
        }
    }
}
