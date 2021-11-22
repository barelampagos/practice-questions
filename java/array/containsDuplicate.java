/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        
        for (int num : nums) {
            if (!uniqueNums.contains(num)) {
                uniqueNums.add(num);
            } else {
                return true;
            }
        }
        
        return false;
    }
}