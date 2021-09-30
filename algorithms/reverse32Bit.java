/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 
32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
 */
class Solution {
    public int reverse(int x) {
        // Check if number is negative
        boolean isNegative = x < 0;
        System.out.println(isNegative);

        // Check length of number
        int num = x;
        int lengthOfNum = 0;
        for (; num != 0; num = num / 10) {
            lengthOfNum++;
        }
    
        System.out.println(lengthOfNum);

        
        // Multiply each digit (num % 10) * (10 ^ length)
        lengthOfNum--;
        
        int reversedNum = 0;      
        int currDigit = 0;
        num = Math.abs(x);
        System.out.println("num: " + num);
        
        for (; num != 0; num = num / 10) {
            currDigit = num % 10;
            System.out.println("CURR DIGIT: " + currDigit);

            reversedNum += currDigit * Math.pow(10, lengthOfNum);
            lengthOfNum--;
            
            // Check exceeds 32 Bit int
            if (reversedNum >= Math.pow(2, 31) - 1 || reversedNum <= -Math.pow(2,31)) {
                reversedNum = 0;
                break;
            }
            
        }
        System.out.println("REV: " + reversedNum);
                
        return isNegative ? -reversedNum : reversedNum;
    }
}