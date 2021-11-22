/**
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
 */
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // Iterate through wordsDict
        int word1Index = -1;
        int word2Index = -1;
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            int distance = 0;
            
            // Find word1 ? mark index 
            if (curr.equals(word1)) {
                word1Index = i;
            } else if (curr.equals(word2)) {
                // Find word2 ? mark index
                word2Index = i;
            }
            
            // Calculate distance from other word and keep minimum
            if (word1Index != -1 && word2Index != -1) {
                distance = Math.abs(word1Index - word2Index);
                minDistance = Math.min(minDistance, distance);
            }
        }
        
        return minDistance;
    }
}