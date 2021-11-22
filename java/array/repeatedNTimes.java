/**
You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.

Example 1:
Input: nums = [1,2,3,3]
Output: 3
 */
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int n = nums.length / 2;
        
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
            } else {
                numCount.put(num, 1);
            }
        }
        
        int nNum = 0;
        
        for (int num : numCount.keySet()) {
            if (numCount.get(num) == n) {
                nNum = num;
                break;
            }
        }
        
        return nNum;
    }
}