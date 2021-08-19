/**
Detect Pattern of Length M Repeated K or More Times

Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.

A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.

arr = [1,2,4,4,4,4], m = 1, k = 3
Output: true

arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
Output: true

NOTE: Incomplete solution, fails on input:
[3,2,2,1,2,2,1,1,1,2,3,2,2]
3
2
 */
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        boolean result = false;
                
        int[] currSubArray = null;
        int[] prevSubArray = null;
        
        int numRepeated = 0;
        
        for (int i = 0; i <= arr.length - m; i += m) {
            // Fetch subarray window of size m (i -> i + m - 1)
            currSubArray = Arrays.copyOfRange(arr, i, i + m);
            
            System.out.println("PREV: " + Arrays.toString(prevSubArray));
            System.out.println("CURR: " + Arrays.toString(currSubArray));
            
            if (prevSubArray == null || !Arrays.equals(prevSubArray,currSubArray)) {
                // Reset sequential
                prevSubArray = currSubArray;
                numRepeated = 1;
            } else if (Arrays.equals(prevSubArray,currSubArray)) {
                numRepeated++;
            }
            
            System.out.println("NUM REPEATED: " + numRepeated);
            
            if (numRepeated == k) {
                result = true;
                break;
            }
        }
        
        return result;
    }
}