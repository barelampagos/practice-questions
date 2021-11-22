/**
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
Given a balanced string s, split it in the maximum amount of balanced strings.
Return the maximum amount of split balanced strings.

Example 1:
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

Example 2:
Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 */
class Solution {
    public int balancedStringSplit(String s) {
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        int pairCount = 0;
        
        for (char letter : s.toCharArray()) {
            if (String.valueOf(letter).equals("R") && lStack.isEmpty()) {
                rStack.push('R');
            } else if (String.valueOf(letter).equals("R") && !lStack.isEmpty()) {
                lStack.pop();
                
                if (lStack.isEmpty()) {
                    pairCount++;
                }
            } else if (String.valueOf(letter).equals("L") && rStack.isEmpty()) {
                lStack.push('L');
            } else if (String.valueOf(letter).equals("L") && !rStack.isEmpty()) {
                rStack.pop();
                
                if (rStack.isEmpty()) {
                    pairCount++;
                }
            }
        }
        
        return pairCount;
    }
}