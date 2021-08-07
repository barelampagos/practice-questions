/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
*/

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                count++;
                countMap.put(num, count);
                
                System.out.println(num + ": " + count);
            } else {
                countMap.put(num, 1);
                System.out.println(num + ": " + 1);
            }
        }

        System.out.println(countMap.toString());

        
        for (Integer key : countMap.keySet()) {
            System.out.println(key);
            if (countMap.get(key) == 1) {
                result = key;
            }
        }
        
        return result;
    }
}
