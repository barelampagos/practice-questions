/**
You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.

 

Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
 */

class Solution {
    
    // Reformat the input license string s, each group (except 1st) will be of length k
    public String licenseKeyFormatting(String s, int k) {

        // Iterate the String backwards
        StringBuilder formattedLicense = new StringBuilder();
        StringBuilder currentGroup = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') 
                continue;
            
            currentGroup.insert(0, s.charAt(i));
            
            if (currentGroup.length() == k) {
                if (formattedLicense.length() != 0) {
                    formattedLicense.insert(0, "-");
                }
                formattedLicense.insert(0, currentGroup.toString().toUpperCase());

                currentGroup = new StringBuilder();

            }
        }
        
        // Prepend remainder
        if (currentGroup.length() > 0) {
            if (formattedLicense.length() != 0) {
                formattedLicense.insert(0, "-");
            }            
            formattedLicense.insert(0, currentGroup.toString().toUpperCase());
        }
        
        return formattedLicense.toString();
    }
    
    /**
        s = "5F3Z-2e-9-w", k = 4
          = [5F3Z, 2e, 9, w]
             
        formattedLicense = 5F3Z-2E9W
        
        currentGroup = 
        */
    
    /**
        s = "2-4A0r7-4k"
        k = 4
        
        formattedLicense = R74K
        currentGroup = 24A0
        **/
}