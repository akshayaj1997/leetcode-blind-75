/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Solution:	
DFS + Backtracking

*/

class Solution {
    int m;
    int n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i < m; i++)
        {
            for(int j=0; j <n ; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                   if(dfs(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean dfs(char[][] board, int row, int col, String word, int index)
    {
        if(index >= word.length()) return true;
        if(row < 0 || col < 0|| row >=m|| col >=n ||visited[row][col] || board[row][col]!=word.charAt(index)) return false;
        visited[row][col] = true;
        for(int[] dir: directions)
        {
            int r = row+dir[0];
            int c = col + dir[1];
            if(dfs(board, r, c, word, index+1)) return true;
        }
        visited[row][col] = false;
        return false;
    }
}
