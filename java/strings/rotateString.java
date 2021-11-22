/**
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        String shifted = "";
        
//         // Substring
//         "abc"
//             "bca": substring(1, n) + substring(0, 1)
//             "cab": substring(2, n) + substring(0, 2)
            
//         "abcd"
//             "bcda"
//             "cdab"
//             "dabc"
        
        for (int i = 1; i < s.length(); i++) {
            shifted = s.substring(i, s.length()) + s.substring(0, i);
            
            //System.out.println(shifted);
            if (shifted.equals(goal)) {
                return true;
            }
        }
                
        return false;
    }
}