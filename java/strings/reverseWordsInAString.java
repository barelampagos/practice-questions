/**
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"
 */
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] reversedWords = new String[words.length];
        
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseString(words[i].toCharArray());
        }
        
        return String.join(" ", reversedWords);
    }
    
    public static String reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            start++;
            end--;
        }
        
        return String.valueOf(s);
    }
}