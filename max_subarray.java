/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Solution:
https://en.wikipedia.org/wiki/Maximum_subarray_problem
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        int curr = 0;
        int best = Integer.MIN_VALUE;
        for(int i=0; i < l; i++)
        {
            dp[i] = Math.max(nums[i], curr+nums[i]);
            best = Math.max(best, dp[i]);
            curr = dp[i];
        }
        return best;
    }
}
