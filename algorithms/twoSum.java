/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // MAP - Key: target - num, Value: index
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        int diff = 0;
        int otherIndex = 0;
        int[] result = new int[2];
        
        // Iterate the nums
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference from target
            diff = target - nums[i];
            
            // Check map if that exists, if so grab that and return with the indexes
            if (sumMap.containsKey(nums[i])) {
                otherIndex = sumMap.get(nums[i]);
                result[0] = otherIndex;
                result[1] = i;
                break;
            } else {
                System.out.println("Adding: " + diff + "," + i);
                sumMap.put(diff, i);
            }
        }
        
        return result;
    }
}