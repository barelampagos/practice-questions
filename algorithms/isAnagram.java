/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = generateCharMap(s);
        HashMap<Character, Integer> tMap = generateCharMap(t);
        
        return sMap.equals(tMap);
    }
    
    
    private static HashMap<Character, Integer> generateCharMap(String word) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        int count;
        
        for (int i = 0; i < word.length(); i++) {
            Character curr = word.charAt(i);
            
            if (countMap.containsKey(curr)) {
                count = countMap.get(curr);
                
                countMap.put(curr, count + 1);
            } else {
                countMap.put(curr, 1);
            }
        } 
        
        return countMap;
    }
}