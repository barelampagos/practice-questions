/**
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:

Input: x = 121
Output: true
 */
class Solution {
    public boolean isPalindrome(int x) {
        // Convert int to String
        String numX = String.valueOf(x);
        
        int start = 0;
        int end = numX.length() - 1;
        
        // Double pointer (start & end) - walk towards each other
        while (start < end) {
            if (numX.charAt(start) != numX.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}