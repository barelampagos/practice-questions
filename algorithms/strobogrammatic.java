/**
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:
Input: num = "69"
Output: true

Example 2:
Input: num = "88"
Output: true
 */
class Solution {
    public boolean isStrobogrammatic(String num) {
        // Number that looks the same when rotated 180 degrees
        boolean strobo = false;
        
        StringBuilder flippedNum = new StringBuilder();
        
        // Iterate through the digits of num
        for (int i = 0; i < num.length(); i++) {
            // Construct an upside down version of num (each digit)
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            int flippedDigit = getFlippedNum(digit);
            
            // Looks the same (equal value?)
            if (flippedDigit < 0) {
                return strobo;
            } else {
                flippedNum.insert(0, flippedDigit);
            }
        }
        
        if (flippedNum.length() > 0) {
            String flippedNumStr = flippedNum.toString();
            strobo = num.equals(flippedNumStr);
        }
        
        return strobo;
    }
    
    private static int getFlippedNum(int digit) {
        HashMap<Integer, Integer> flipMap = new HashMap<>();
        flipMap.put(0, 0);
        flipMap.put(1, 1);
        flipMap.put(2, -1);  //?
        flipMap.put(3, -1); // ?
        flipMap.put(4, -1);  // ?
        flipMap.put(5, -1);
        flipMap.put(6, 9);
        flipMap.put(7, -1);
        flipMap.put(8, 8);
        flipMap.put(9, 6);
        
        return flipMap.get(digit);        
    }
}