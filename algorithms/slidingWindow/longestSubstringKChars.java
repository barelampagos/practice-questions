/**
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> uniqueChars = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        
        if (k == 0) {
            return 0;
        }
        
        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            
            // Check if character exists in map, shrink map while size > k
            while (!uniqueChars.containsKey(curr) && uniqueChars.keySet().size() == k) {
                // Remove from front
                //System.out.println("RM -- " + s.charAt(start));
                
                int count = uniqueChars.get(s.charAt(start)) - 1;
                if (count > 0) {
                    uniqueChars.put(s.charAt(start), count);
                } else {
                    uniqueChars.remove(s.charAt(start));
                }
                start++;
            }
            
            //System.out.println("ADD --" + curr);
            
            // Add char + count to HM
            if (uniqueChars.containsKey(curr)) {
                uniqueChars.put(curr, uniqueChars.get(curr) + 1);   
            } else {
                uniqueChars.put(curr, 1);
            }
            
            // Calculate maxLength
            if (uniqueChars.keySet().size() <= k) {
                maxLength = Math.max(maxLength, (end - start) + 1);
            }
        }
        
        return maxLength;
    }
}

/**

"aa"
0

"aa"
1

"abaccc"
2

"a"
0

*/
