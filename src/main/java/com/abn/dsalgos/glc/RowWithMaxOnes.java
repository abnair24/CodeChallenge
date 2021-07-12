package com.abn.dsalgos.glc;

/*
Given a MxN boolean matrix, find the row with maximum no of one's. Each row is sorted


 0 0 0 0 1
 0 0 1 1 1
 0 1 1 1 1
 0 0 0 1 1
 1 1 1 1 1

 o/p: 5 (4th row)

 */
public class RowWithMaxOnes {

    public int rowWithMax(int[][] matrix) {

       int rows = matrix.length;
       int cols = matrix[0].length;
       int current_col = cols - 1;

       int maxRowIndex = -1;
       int maxCount = 0;

       for(int i = 0; i < rows; i++) {

           while(current_col >= 0 && matrix[i][current_col] == 1) {
               current_col --;
               maxRowIndex = i;
               maxCount++;
           }

           if(maxCount == cols) {
               return maxRowIndex;
           }
       }
       return maxRowIndex;
    }
}
