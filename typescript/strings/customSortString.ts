/**
You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

Example 1:
Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 * @param order 
 * @param s 
 * @returns 
 */
function customSortString(order: string, s: string): string {
    let charMap: Map<string, number> = new Map();
    let result: string = ''
    
    // Obtain valid chars
    for (let i = 0; i < s.length; i++) {
        let curr: string = s.charAt(i);
        
        if (charMap.has(curr)) {
            charMap.set(curr, charMap.get(curr) + 1)
        } else {
            charMap.set(curr, 1)
        }
    }
    
    // Walk through order
    for (let i = 0; i < order.length; i++) {
        let curr: string = order.charAt(i);
        
        if (charMap.has(curr)) {
            
            for (let ct = 0; ct < charMap.get(curr); ct++) {
                result += curr;
            }
            
            charMap.delete(curr);
        }
    }
    
    // Add remaining keys
    let remaining: string[] = [...charMap.keys()];
    if (remaining.length > 0) {
        for (let leftoverChar of remaining) {
            for (let ct = 0; ct < charMap.get(leftoverChar); ct++) {
                result += leftoverChar
            }
        }
    }
    
    return result;
};