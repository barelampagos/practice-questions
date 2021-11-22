/**
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        boolean matchPattern = true;
        
        // Obtain array of words
        String[] sWords = s.split(" ");
        
        // Cannot match pattern if uneven
        if (pattern.length() != sWords.length) {
            return false;
        }
        
        HashMap<Character, String> patternMap = new HashMap<>();
        
        // Iterate both pattern & s in parallel
        for (int i = 0; i < sWords.length; i++) {
            // For each character encountered in pattern, map to word in string s
            Character patChar =  pattern.charAt(i);
            String sWord = sWords[i];

            // Second time (already exists) --> check against map
            // Case 1: Contains patternKey & value does not match
            if (patternMap.containsKey(patChar) && !patternMap.get(patChar).equals(sWord)) {
                // Else, pattern broken --> return false
                return false;                
            } else if (patternMap.containsValue(sWord)) {
                // Case 2: Value exists in map already (but to a different key?)
                if (patternMap.get(patChar) == null) {
                    return false;
                }
            } else {
                // First time --> Map
                patternMap.put(patChar, sWord);
            }
        }
        
        return matchPattern;
    }
}