/**
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"
 */
class Solution {
    public String toLowerCase(String s) {
        char[] letters = s.toCharArray();
        
        for (int i = 0; i < letters.length; i++) {
            // Capital ASCII values < 90 (A 65 - Z 90)
            // Lowecase ASCII values > 97 (a 97 - z 122)
            if (letters[i] <= 90 && letters[i] >= 65) {
                letters[i] = (char) (letters[i] + ('a' - 'A'));
            }
        }
        
        return new String(letters);
    }
}