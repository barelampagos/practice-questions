/**
An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. For example:

0, 1, and 8 rotate to themselves,
2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
6 and 9 rotate to each other, and
the rest of the numbers do not rotate to any other number and become invalid.
Given an integer n, return the number of good integers in the range [1, n].

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */

class Solution {
    public int rotatedDigits(int n) {
        // DP - Pregenerate values on the way to n
        HashMap<Integer, Integer> rotateMap = initializeRotateMap();
        int goodIntCount = 0;
        
        // Iterate 1 -> n
        for (int i = 1; i <= n; i++) {
            //System.out.println("==========");
            //System.out.println("CURR NUM: " + i);
            
            // Convert i to String (to fetch digits)
            String currStr = String.valueOf(i);
            boolean validNum = true;
            
            StringBuilder generatedNum = new StringBuilder();
            
            // For each digit in i, check against rotateMap
            for (char currChar : currStr.toCharArray()) {
                //System.out.println("-- DIGIT: " + currChar);
                
                // 1. Check if number generated after rotating all digits is valid
                Integer rotatedNum = rotateMap.get(Integer.parseInt(String.valueOf(currChar)));
                
                if (rotatedNum == -1) {
                    //System.out.println("---- INVALID: " + rotatedNum);
                    
                    // Invalid result, can break immediately
                    validNum = false;
                    break;
                } else {
                    //System.out.println("---- VALID: " + rotatedNum);
                    generatedNum.append(String.valueOf(rotatedNum));
                }
            }
            
            if (validNum) {
                // 2. Check if the number generated is different
                Integer fullyRotatedNum = Integer.valueOf(generatedNum.toString());
                //System.out.println("[GENERATED NUM VALID]: " + fullyRotatedNum);
                
                if (fullyRotatedNum != i) {
                    goodIntCount++;
                    //System.out.println("[NUM GENERATED --> GOOD, INCREMENT COUNT]: " + goodIntCount);
                }
            }
        }
        
        return goodIntCount;
    }
    
    private static HashMap initializeRotateMap() {
        HashMap<Integer, Integer> rotateMap = new HashMap<>();
        rotateMap.put(0, 0);
        rotateMap.put(1, 1);
        rotateMap.put(2, 5);
        rotateMap.put(3, -1);
        rotateMap.put(4, -1);
        rotateMap.put(5, 2);
        rotateMap.put(6, 9);
        rotateMap.put(7, -1);
        rotateMap.put(8, 8);
        rotateMap.put(9, 6);
        
        return rotateMap;
    }
}

 // n = 10
    // Good: Rotate to valid diff number
    /*
        0 --> 0, N: 
        1 --> 1, N: same num
        2 --> 5, Y: new num ++
        3 --> VOID, N: void
        4 --> V, N: Void
        5 --> 2, Y: new num ++
        6 --> 9, Y: new num ++
        7 --> V, N
        8 --> 8, N
        9 --> 6, Y: new num ++
        10 --> for each digit, check the HashMap? 
            1 = N
            0 = N
            --> NO
        11 --> 
            1 = N
            1 = N
            --> NO

        12 --> 
            1 = N
            2 = Y, 5    
            15 = new num ++
        13 --> 
            1 = N
            3 = V
    */
