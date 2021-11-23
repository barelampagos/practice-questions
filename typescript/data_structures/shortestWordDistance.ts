/**
Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 

Example 1:
Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1
 */
class WordDistance {
    words: string[];
    wordMap: Map<string, number[]>;
    
    constructor(wordsDict: string[]) {
        this.words = wordsDict;
        this.wordMap = new Map();
        
        for (let i = 0; i < this.words.length; i++) {
            if (this.wordMap.has(this.words[i])) {
                let updatedIndexes: number[] = this.wordMap.get(this.words[i])
                updatedIndexes.push(i);
                this.wordMap.set(this.words[i], updatedIndexes);
            } else {
                this.wordMap.set(this.words[i], [i])
            }
        }
    }

    shortest(word1: string, word2: string): number {
        let minDistance: number = Number.MAX_SAFE_INTEGER;
        let w1Indexes: number[] = this.wordMap.get(word1);
        let w2Indexes: number[] = this.wordMap.get(word2);
        
        for (let w1Index of w1Indexes) {
            for (let w2Index of w2Indexes) {
                minDistance = Math.min(Math.abs(w1Index - w2Index), minDistance);
            }
        }
        
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(wordsDict)
 * var param_1 = obj.shortest(word1,word2)
 */