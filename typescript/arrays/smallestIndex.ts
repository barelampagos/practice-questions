/**
Given a 0-indexed integer array nums, return the smallest index i of nums such that i mod 10 == nums[i], or -1 if such index does not exist.

x mod y denotes the remainder when x is divided by y.

Example 1:
Input: nums = [0,1,2]
Output: 0
 */
function smallestEqual(nums: number[]): number {
    let smallestIndex: number = -1;
    
    for (let i = 0; i < nums.length; i++) {
        if (i % 10 == nums[i]) {
            if (smallestIndex == -1) {
                smallestIndex = i;
            } else {
                smallestIndex = Math.min(smallestIndex, i);
            }
        }
    }
    
    return smallestIndex;
};