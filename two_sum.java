/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Solution:
Use a hashset to store the difference of sum and value seen so far, if the hashset contains the upcoming value return pair, else return empty pair.
*/
class Solution {
  
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(sums.containsKey(target-nums[i])) return new int[] {i, sums.get(target-nums[i])};
            if(!sums.containsKey(nums[i])) sums.put(nums[i], i);
        }
        return new int[2];
    }
  
}
