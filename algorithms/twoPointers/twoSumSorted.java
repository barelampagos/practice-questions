/**
Given a 0-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 0 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1 + 1, index2 + 1] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 0, index2 = 1. We return [0+1, 1+1].
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int sum = 0;
        
        while (start < end) {
            sum = nums[start] + nums[end];
            //System.out.println(sum);

            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                break;
            }
        }
        
        return new int[]{start + 1, end + 1};
    }
}

/*

[2,7,11,15]
9

*/