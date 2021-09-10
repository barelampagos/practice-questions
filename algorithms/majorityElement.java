/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        double majorityVal = nums.length / 3;
        int majority = (int) Math.floor(majorityVal);
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                count++;
                countMap.put(num, count);
            } else {
                countMap.put(num, 1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int num : countMap.keySet()) {
            if (countMap.get(num) > majority) {
                result.add(num);
            }
        }
        
        return result;
    }
}