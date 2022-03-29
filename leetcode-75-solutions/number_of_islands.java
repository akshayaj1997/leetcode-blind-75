/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Solution:
Use DFS/BFS.
*/
class Solution {
      int m;
       int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0; i < m; i++)
        {
            for(int j=0; j < n; j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    private void dfs(char[][] grid, int row, int col)
    {
        if(row < 0 || col < 0 || row >=m || col >= n || grid[row][col] == '0') return;
        grid[row][col] = '0';
        for(int[] dir: directions)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r,c);
        }
    }
}
