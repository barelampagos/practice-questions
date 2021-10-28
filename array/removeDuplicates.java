/**
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        int currUnique = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNums.contains(nums[i])) {
                uniqueNums.add(nums[i]);
                
                if (currUnique != i) {
                    // Swap
                    int temp = nums[currUnique];
                    nums[currUnique] = nums[i];
                    nums[i] = temp;
                }
                currUnique = currUnique + 1;
            } 
            
            //System.out.println(Arrays.toString(nums));
        }
        
        return uniqueNums.size();
    }
}
/*
[1,1,2]

[0,0,1,1,1,2,2,3,3,4]
*/