/**
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
 */
class Solution {
    public int addDigits(int num) {
        String strInt = String.valueOf(num);
        
        while (strInt.length() > 1) {
            int newSum = 0;
            char[] charDig = strInt.toCharArray();
            
            for (char digit : charDig) {
                System.out.println("DIGIT: " + digit);

                int value = Integer.parseInt(String.valueOf(digit));
                newSum += value;
                
                System.out.println("Sum: " + newSum);
            }
            
            strInt = String.valueOf(newSum);
        }
        
        return Integer.parseInt(strInt);
    }
}