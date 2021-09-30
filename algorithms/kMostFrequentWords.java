/**
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> countMap = new TreeMap<>();
        String curr;
        int maxCount = 0;
        
        // Iterate through the words array, maintain a count of each word we encounter
        for (int i = 0; i < words.length; i++) {
            curr = words[i];
            
            int count = 1;
            
            // Maintain count in HashMap <K: word, V: count> (TreeMap to maintain sorting)
            if (countMap.containsKey(curr)) {
                count = countMap.get(curr);
                count++;
                countMap.put(curr, count);
            } else {
                // Init new word
                countMap.put(curr, count);
            }
            
            // Maintain the maxValue of any count as we iterate (2)
            if (count > maxCount) {
                maxCount = count;
            }
            
            //System.out.println(curr + ": " + countMap.get(curr));
        }
        
        // Generate output List
        ArrayList<String> results = new ArrayList<>();
        int remainingK = k;
        
        while (remainingK >= 0) {
            for (String key : countMap.keySet()) {
                //System.out.println(key + " --> " + countMap.get(key));
                if (countMap.get(key) == maxCount) {
                    results.add(key);
                    remainingK--;
                }
                
                if (remainingK == 0)
                    break;
            }
            
            if (remainingK == 0)
                break;
            
            maxCount--;
        }
        
        return results;
    }
}