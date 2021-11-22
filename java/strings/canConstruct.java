/**
Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineLetters = new HashMap<>();
        
        // Obtain all characters
        for (Character letter : magazine.toCharArray()) {
            if (magazineLetters.containsKey(letter)) {
                magazineLetters.put(letter, magazineLetters.get(letter) + 1);
            } else {
                magazineLetters.put(letter, 1);
            }
        }
        
        boolean constructNote = true;
        
        for (Character letter : ransomNote.toCharArray()) {
            if (magazineLetters.containsKey(letter)) {
                int count = magazineLetters.get(letter);
                count--;
                
                if (count == 0) {
                    magazineLetters.remove(letter);
                } else {
                    magazineLetters.put(letter, count);
                }
            } else {
                constructNote = false;
                break;
            }
        }
        
        return constructNote;
    }
}