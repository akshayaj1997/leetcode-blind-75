/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:

Input: nums = [1,2,3,1]
Output: true

Solution: 

Use a hashset to store the values seen so far, if the hashset contains the upcoming value return true, else return false.

*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> present = new HashSet<Integer>();
        for(int i: nums)
        {
            if(present.contains(i)) return true;
            present.add(i);
        }
        return false;
    }
}
