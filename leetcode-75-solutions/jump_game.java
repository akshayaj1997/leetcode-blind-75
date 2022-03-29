/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

public class Solution {
    public bool CanJump(int[] nums) {
        int[] jumps = new int[nums.Length];
        int n = nums.Length;
        if(nums[0] == 0 && nums.Length == 1) return true;
        if((nums.Length ==0 || nums[0] == 0)) return false;
        jumps[0] = 0;
         for (int i = 1; i < n; i++) {
            jumps[i] = int.MaxValue;
            for (int j = 0; j < i; j++) {
                if (i <= j + nums[j] && jumps[j] != int.MaxValue) {
                    jumps[i] = Math.Min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n-1] !=  int.MaxValue;
    }
}
