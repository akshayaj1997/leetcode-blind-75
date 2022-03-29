/*

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
Example:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Solution:

BFS starting with the edges and add all the points that intersect from pacific and atlantic. The left edge and top is pacific and right edge and bottom are atlantic
BFS is done by passing the queue to the bfs with the edge points added to it.
*/

class Solution {
    int[][] directions = {{0,1}, {0,-1}, {-1,0},{1,0}};
    int m;
    int n;
    int[][] grid;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacific = new LinkedList<int[]>();
        Queue<int[]> atlantic = new LinkedList<int[]>();
        m = heights.length;
        n = heights[0].length;
        grid = heights;
       
         for(int i=0; i<m;i++)
        {
            pacific.offer(new int[]{i,0});
            atlantic.offer(new int[]{i,n-1});
        }
         for(int i=0; i<n;i++)
        {
            pacific.offer(new int[]{0,i});
            atlantic.offer(new int[]{m-1, i});
        }
        boolean[][] pRegions = bfs(pacific);
        boolean[][] aRegions = bfs(atlantic);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0; i <m; i++)
        {
            for(int j=0; j < n; j++)
            {
                if(pRegions[i][j] && aRegions[i][j])
                {
                    List<Integer> point = new ArrayList<Integer>();
                    point.add(i);
                    point.add(j);
                    ans.add(point);
                }
            }
        }
        return ans;
    }
    
    private boolean[][] bfs(Queue<int[]> queue)
    {
        boolean[][] reached = new boolean[m][n];
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            reached[curr[0]][curr[1]] =true;
            for(int[] dir: directions)
            {
                int row = dir[0] + curr[0];
                int col = dir[1] + curr[1];
                if(row < 0 || col < 0 || row >=m || col>=n || reached[row][col]) continue;
                if(grid[curr[0]][curr[1]] > grid[row][col]) continue;
                queue.offer(new int[]{row, col});
                reached[row][col] =true;
            }
        }
        return reached;
    }
}
