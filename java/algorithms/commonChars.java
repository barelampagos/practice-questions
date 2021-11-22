/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
*/
class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> charMap = null;
        HashMap<Character, Integer> currWordMap = null;
        HashMap<Character, Integer> tempMap = null;

        for (String word : words) {
            currWordMap = new HashMap<>();
            char[] chars = word.toCharArray();
            
            // Gather letters
            for (char letter: chars) {
                if (currWordMap.containsKey(letter)) {
                    currWordMap.put(letter, currWordMap.get(letter) + 1);
                } else {
                    currWordMap.put(letter, 1);
                }
            }
            
            // Compare against charMap 
            if (charMap == null) {
                charMap = currWordMap;
            } else {
                tempMap = new HashMap<>();
                
                for (Character letter : charMap.keySet()) {
                    if (currWordMap.containsKey(letter) && currWordMap.get(letter) != charMap.get(letter)) {
                        // Update count
                        tempMap.put(letter, Math.min(currWordMap.get(letter), charMap.get(letter)));
                    } else if (currWordMap.containsKey(letter) && currWordMap.get(letter) == charMap.get(letter)) {
                        // Match
                        tempMap.put(letter, charMap.get(letter));
                    } 
                }
                
                charMap = tempMap;
            }
        }
        
        // Aggregate solution
        ArrayList<String> results = new ArrayList<>();
        for (Character key : charMap.keySet()) {
            int count = charMap.get(key);
            
            for (int i = 0; i < count; i++) {
                results.add(String.valueOf(key));
            }
        }
        
        return results;
    }
}

/*

K: letter, V: freq
b 1
e 1
l 2
a 1

bella

l 2
e 1

label

r 2
o 1
l 2
e 1

roller


*/