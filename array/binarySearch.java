/**
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int resultIndex = -1;
        
        while (start <= end) {
            // Find middle of section we're looking at
            int middleIndex = (start + end) / 2;
            System.out.println(middleIndex);
            
            if (nums[middleIndex] == target) {
                resultIndex = middleIndex;
                break;
            } else if (nums[middleIndex] > target) {
                end = middleIndex - 1;
            } else if (nums[middleIndex] < target) {
                start = middleIndex + 1;
            }
        }
        
        return resultIndex;
    }
}