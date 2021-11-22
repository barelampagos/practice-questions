/**
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
Example 4:

Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String divisor = "";
        int divisorIndex = 0;
        
        int s1Ptr = 0;
        int s2Ptr = 0;
        
        // Generate divisorIndex by incr while chars match (roughly)
        while (s1Ptr < str1.length() && s2Ptr < str2.length()) {
            if (str1.charAt(s1Ptr) == str2.charAt(s2Ptr)) {
                s1Ptr++;
                s2Ptr++;
                divisorIndex++;
            } else {
                break;
            }
        }
        
        // Try to "divide" the potential divisor into longer string, if possible
        String str1Copy;
        String str2Copy;

        String largerDividend = str1.length() > str2.length() ? str1 : str2;
        
        while (divisorIndex > 0) {
            divisor = largerDividend.substring(0, divisorIndex);
            System.out.println("DIV: " + divisor);
            
            // Ensure properly divisible for both Strings
            str1Copy = new String(str1);
            str1Copy = str1Copy.replace(divisor, "");
            
            System.out.println("REM-1: " + str1Copy);
            
            str2Copy = new String(str2);
            str2Copy = str2Copy.replace(divisor, "");
            
            System.out.println("REM-2: " + str2Copy);
            
            // If no "remainder" in both Strings, divisor found
            if (str1Copy.isEmpty() && str2Copy.isEmpty()) {
                break;
            } else {
                // Reduce length of divisor String
                divisorIndex--;
            }
        }
                
        return divisorIndex > 0 && divisor.length() > 0 ? divisor : "";
    }
}