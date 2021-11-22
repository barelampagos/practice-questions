/**
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.

Return the sum of each integer in nestedList multiplied by its weight.

Example 1:
Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8

 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private static HashMap<Integer, Integer> countMap;
    private static HashMap<Integer, List<Integer>> depthMap;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        int sum = 0;
        int weight = 0;
        
        countMap = new HashMap<>(); // K: Num, V: Count
        depthMap = new HashMap<>(); // K: Depth, V: Numbers at depth
        
        // Recurse and populate maps
        processList(nestedList, 1);
        
        // Get maxDepth
        for (Integer depth : depthMap.keySet()) {
            maxDepth = Math.max(maxDepth, depth);
        }
        
        System.out.println("MAX DEPTH: " + maxDepth);
        
        // Sum values
        for (Integer depth : depthMap.keySet()) {
            List<Integer> vals = depthMap.get(depth);
            System.out.println("DEPTH " + depth + " = " + vals);
            
            weight = maxDepth - (depth) + 1;
            
            for (Integer val : vals) {
                sum += val * weight;
            }
        }
        
        return sum;
    }
    
    private static void processList(List<NestedInteger> nestedList, int currDepth) {
        // Iterate through nestedList
        for (NestedInteger nested : nestedList) {
            // If integer (process)
            if (nested.isInteger()) {
                int currInt = nested.getInteger();
                
                // Increment count
                if (countMap.containsKey(currInt)) {
                    countMap.put(currInt, countMap.get(currInt) + 1);
                } else {
                    countMap.put(currInt, 1);
                }
                
                // Increment weight
                if (depthMap.containsKey(currDepth)) {
                    List<Integer> values = depthMap.get(currDepth);
                    values.add(currInt);
                    depthMap.put(currDepth, values);
                } else {
                    List<Integer> values = new ArrayList<>();
                    values.add(currInt);
                    depthMap.put(currDepth, values);
                }
            } else {
                // If list (process each)
                processList(nested.getList(), currDepth + 1);
            }
            
        }
    }
}