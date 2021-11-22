/**
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = 0;
        int start = 0;
        int currSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            // Shrink window: Try to remove front elements until less than target
            while (currSum >= target) {
                int subLen = (i - start) + 1;
                minSize = minSize == 0 ? subLen : Math.min(minSize, subLen);
                
                currSum -= nums[start];
                start++;
            }

        }
        
        return minSize;
    }
}