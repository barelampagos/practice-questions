/**
Given a string s, return true if a permutation of the string could form a palindrome.

Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (charMap.containsKey(curr)) {
                charMap.put(curr, charMap.get(curr) + 1);
            } else {
                charMap.put(curr, 1);
            }
        }
        
        boolean hasMiddleChar = false;
        boolean canPerm = true;
        
        for (Character key : charMap.keySet()) {
            if (charMap.get(key) % 2 != 0 && !hasMiddleChar) {
                // Odd case - first time
                hasMiddleChar = true;
            } else if (charMap.get(key) % 2 != 0 && hasMiddleChar) {
                // Odd case - 2nd time - return false
                canPerm = false;
                break;
            } 
        }
        
        return canPerm;
    }
}