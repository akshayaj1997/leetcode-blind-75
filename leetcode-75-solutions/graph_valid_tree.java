/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example:
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Solution:
Use union find, but instead of making union function void make it return bool. Also check if the no of edges is n-1 as it should be in a tree

*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        UnionFind disjoint = new UnionFind(n);
        for(int[] edge: edges)
        {
            if(!disjoint.Union(edge[0], edge[1])) return false;
        }
        return true;
    }
    
    class UnionFind {
        int[] root;
        public UnionFind(int x)
        {
            root = new int[x];
            for(int i=0; i < x; i++)
                root[i] = i;
        }
        public boolean Union(int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return false;
            root[rootY] = rootX;
            return true;
        }
        public int find(int x)
        {
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }
    }
}
