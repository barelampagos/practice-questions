/**
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        int temp = 0;
        
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("CURR: " + nums[i]);
            
            if (nums[i] != 0) {
                int currIndex = i;
                
                while (currIndex != startIndex && currIndex - 1 >= 0) {
                    temp = nums[currIndex];
                    nums[currIndex] = nums[currIndex - 1];
                    nums[currIndex - 1] = temp;
                    
                    currIndex--;
                    //System.out.println("CURRINDEX: " + currIndex);
                }
                startIndex = currIndex + 1;
                //System.out.println(Arrays.toString(nums));
            }
        }
    }
}

// [0, 1, 0, 3, 12]
// [1, 0, 0, 3, 12]
// [1, 0, 0, 3, 12]
// [1, 0, 3, 0, 12]
// [1, 0, 3, 12, 0]