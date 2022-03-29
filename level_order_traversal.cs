/**
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Solution:
BFS using queue.

**/

public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        List<IList<int>> ans = new List<IList<int>>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        while(true)
        {
            int size = queue.Count;
            if(size == 0) break;
            List<int> level = new List<int>();
            while(size > 0)
            {
                TreeNode curr = queue.Dequeue();
                level.Add(curr.val);
                if(curr.left!=null)queue.Enqueue(curr.left);
                if(curr.right!=null)queue.Enqueue(curr.right);
                size--;
            }
            ans.Add(level);
        }
        return ans;
    }
}
