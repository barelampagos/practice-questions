/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int base = nums.length > 0 ? nums[0] : 0;
        int maxSoFar = nums.length > 0 ? nums[0] : 0;
        
        for (int i = 1; i < nums.length; i++) {
            base = Math.max(base + nums[i], nums[i]);
            maxSoFar = Math.max(base, maxSoFar);
            
            //System.out.println("BASE: " + base);
            //System.out.println("MAX SO FAR: " + maxSoFar);
        }
        
        return maxSoFar;
    }
}