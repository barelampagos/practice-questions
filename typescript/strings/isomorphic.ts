/**
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
 */
function isIsomorphic(s: string, t: string): boolean {
    let charMap: Map<string, string> = new Map();
    let invCharMap: Map<string, string> = new Map();
    let isomorphic: boolean = true;
    
    for (let i = 0; i < s.length; i++) {
        let sChar: string = s.charAt(i);
        let tChar: string = t.charAt(i);
        
        if ((charMap.has(sChar) && charMap.get(sChar) != tChar) || (invCharMap.has(tChar) && invCharMap.get(tChar) != sChar)) {
            isomorphic = false;
            break;
        } else {
            charMap.set(sChar, tChar);
            invCharMap.set(tChar, sChar);
        }
    }
    
    return isomorphic;
};