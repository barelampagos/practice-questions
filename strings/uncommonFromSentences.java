/**
A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> uniqueWordsS1 = new HashMap<>();
        HashMap<String, Integer> uniqueWordsS2 = new HashMap<>();
        
        String[] s1Split = s1.split(" ");
        String[] s2Split = s2.split(" ");
        
        // Iterate s1, add in each word
        evaluateWord(s1Split, uniqueWordsS1);
        
        // Iterate s2
        evaluateWord(s2Split, uniqueWordsS2);
        
        ArrayList<String> uniqueWords = new ArrayList<>();
        
        for (String key : uniqueWordsS1.keySet()) {
            if (uniqueWordsS1.get(key) == 1 && uniqueWordsS2.get(key) == null) {
                uniqueWords.add(key);
            } 
        }
        
        for (String key : uniqueWordsS2.keySet()) {
            if (uniqueWordsS2.get(key) == 1 && uniqueWordsS1.get(key) == null) {
                uniqueWords.add(key);
            } 
        }
        
        String[] results = new String[uniqueWords.size()];
        results = uniqueWords.toArray(results);
        
        return results;
    }
    
    private void evaluateWord(String[] split, HashMap<String, Integer> wordCountMap) {
        // Iterate s1, add in each word
        for (String word : split) {
            //System.out.println(word);
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // if doesnt --> add
                wordCountMap.put(word, 1);
            }
        }
    }
}