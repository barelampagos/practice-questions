/**
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int[] allNums = new int[nums.length + 1];
        int result = 0;
        
        // Set all values to proper index
        for (int i = 0; i < nums.length; i++) {
            allNums[nums[i]] = nums[i];
        }
        
        System.out.println(Arrays.toString(allNums));
        
        // Find where i != nums[i]
        for (int i = 0; i < allNums.length; i++) {
            if (allNums[i] != i) {
                result = i;
            }
        }
        
        return result;
    }

    public int missingNumberCyclicSort(int[] nums) {
        sort(nums);
        int result = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                result = i;
            }
        }
        
        return result;
    }
    
    // Cyclic sort
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
          int j = nums[i];
          if (nums[i] < nums.length && nums[i] != nums[j])
            swap(nums, i, j);
          else
            i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}