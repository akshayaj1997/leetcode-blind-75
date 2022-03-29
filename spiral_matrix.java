/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Examples:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Solution:
Use variables to set the 1st and last rows and columns and one to maintain the count of numbers printed, initially print 1st row, last column and so on. 
Use 4 for loops. Once 1st row and last row and 1st column and last column reach the same point and the count of values reaches max, break out of while
and return
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         List<Integer> res = new ArrayList<Integer>();
         int firstRow = 0;
         int lastRow = m-1;
         int firstCol = 0;
         int lastCol = n-1;
         int element = m*n;
         while(element > 0 && firstRow <= lastRow && firstCol <= lastCol)
         {
             for(int i=firstCol; i<=lastCol; i++)
             {
                 res.add(matrix[firstRow][i]);
                 element--;
             }
             if(element == 0) break;
             firstRow++;
             for(int i=firstRow; i<=lastRow; i++)
             {
                 res.add(matrix[i][lastCol]);
                 element--;
             }
              if(element == 0) break;
             lastCol--;
             for(int i=lastCol; i>=firstCol; i--)
             {
                 res.add(matrix[lastRow][i]);
                 element--;
             }
              if(element == 0) break;
             lastRow--;
             for(int i= lastRow; i>=firstRow; i--)
             {
                 res.add(matrix[i][firstCol]);
                 element--;
             }
             if(element == 0) break;
             firstCol++;
         }
         return res;
    }
}
