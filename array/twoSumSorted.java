/**
Given a 0-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 0 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1 + 1, index2 + 1] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 0, index2 = 1. We return [0+1, 1+1].
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int firstIndex = -1;
        int otherIndex = -1;
        
        for (int i = 0; i < numbers.length; i++) {
            int currNum = numbers[i];
            firstIndex = i;
            int diff = target - currNum;
            //System.out.println("CURR " + currNum);
            
            if (numMap.containsKey(diff)) {
                otherIndex = numMap.get(diff);
            } else {
                numMap.put(currNum, i);                
                // Binary search for value in numbers
                otherIndex = binarySearch(numbers, diff, numMap);
            }
                        
            // Set lower value
            if (otherIndex != -1 && firstIndex != otherIndex) {
                result[0] = (firstIndex < otherIndex ? firstIndex : otherIndex) + 1 ;
                result[1] = (firstIndex > otherIndex ? firstIndex : otherIndex) + 1;
                break;
            }
        }
        
        return result;
    }
    
    public int binarySearch(int[] numbers, int target, HashMap<Integer, Integer> numMap) {
        int resultIndex = -1;
        
        int start = 0;
        int end = numbers.length - 1;
        
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int current = numbers[middle];
            
            if (!numMap.containsKey(current)) {
                numMap.put(current, middle);
            }
            
            if (current == target) {
                resultIndex = middle;
                break;
            } else if (current < target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        
        return resultIndex;
    }
}

/*

[2,7,11,15]
9

*/