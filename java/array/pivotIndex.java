/**
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1. */
class Solution {
    public int pivotIndex(int[] nums) {
        int pivotIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            
            while (leftIndex >= 0) {
                leftSum += nums[leftIndex];
                leftIndex--;
            }
            
            while (rightIndex < nums.length) {
                rightSum += nums[rightIndex];
                rightIndex++;
            }
            
            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }
        
        return pivotIndex;
    }
}