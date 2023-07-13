package com.abn.dsalgos.challenges.problems;

public class StarPrint {


    public void matrixPrint(int n) {

        int row = 0;
        int col = n - 1 ;
        String[][] matrix = new String [n][n];

        for(int i = row; i < n; i ++) {
            for(int j = 0; j < n; j++)  {

                if(j >= col - i) {
                    matrix[i][j] = ":";
                } else {
                    matrix[i][j] = "-";
                }

            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StarPrint starPrint = new StarPrint();
        starPrint.matrixPrint(20);

    }
}
