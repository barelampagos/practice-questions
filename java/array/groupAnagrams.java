/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> groupedAnagramMap = new HashMap<>();
        
        for (String word : strs) {
            HashMap<Character, Integer> wordMap = generateWordMap(word);
            
            if (groupedAnagramMap.containsKey(wordMap)) {
                List<String> wordList = groupedAnagramMap.get(wordMap);
                wordList.add(word);
                groupedAnagramMap.put(wordMap, wordList);
            } else {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                groupedAnagramMap.put(wordMap, wordList);
            }
        }
        
        List<List<String>> results = new ArrayList<>();
        
        for (List<String> group : groupedAnagramMap.values()) {
            results.add(group);
        }
        
        return results;
    }
    
    public static HashMap<Character, Integer> generateWordMap(String word) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        
        for (char letter : word.toCharArray()) {
            if (wordMap.containsKey(letter)) {
                wordMap.put(letter, wordMap.get(letter) + 1);
            } else {
                wordMap.put(letter, 1);
            }
        }
        
        return wordMap;
    }
}

// 1. WordMap - For each str --> HM - K: char, V: count

// 2. GroupedAnagramMap - HashMap<HashMap<Character, Int>, List<String>>

// 3. GroupedAnagramMap.containsKey(WordMap) --> add String to List
// GroupedAnagramMap.put(WordMap, new List(String))

