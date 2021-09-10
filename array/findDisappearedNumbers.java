/**
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // Initial Solution:
        // nums = [4,3,2,7,8,2,3,1] --> length = 8
        // expect numbers: 1 --> 8
        int n = nums.length;
        int[] countedNums = new int[n];

        // Set encountered numbers = 1
        for (int num : nums) {
            int index = num - 1;
            countedNums[index] = 1;
        }

        System.out.println(Arrays.toString(countedNums));

        // Fetch all numbers that are not seen (countedNums[i] != 1)
        List<Integer> missingNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (countedNums[i] != 1) {
                missingNums.add(i + 1);
            }
        }

        System.out.println(Arrays.toString(missingNums.toArray()));
        
        
        // Follow Up: No extra space + 0(n)
        //         int n = nums.length;
        //         List<Integer> missingNums = new ArrayList<>();
                
        //         for (int i = 0; i < n; i++) {
        //             if (!missingNums.contains(i + 1)) {
        //                 missingNums.add(i + 1);
        //             }
        //         }
                
        //         for (int num : nums) {
        //             if (missingNums.contains(num)) {
        //                 missingNums.remove(Integer.valueOf(num));
        //             }
        //         }
        //         System.out.println(Arrays.toString(missingNums.toArray()));
        
        return missingNums;
    }
}