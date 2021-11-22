/**
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = generateText(s);
        Stack<Character> tStack = generateText(t);
        
        return sStack.equals(tStack);
    }
    
    public static Stack<Character> generateText(String word) {
        Stack<Character> st = new Stack<>();
        
        for (char letter : word.toCharArray()) {
            if (letter == '#' && !st.isEmpty()) {
                st.pop();
            } else if (letter != '#') {
                st.push(letter);
            }
        }
        
        return st;
    }
}