/**
 *
NOTE: INCOMPLETE SOLUTION

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes). 

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3

Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 *     
 * 
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // Recursively 
        if (root == null) {
            return 0;
        }

        // System.out.println("========");
        // System.out.println("ROOT: " + root.val);
        // System.out.println("TARGET: " + targetSum);

        int diff = targetSum - root.val;
        
        // Found sum option
        if (diff == 0) {
            System.out.println("[INCREMENT ++]");
            return 1;
        }

        int left = Math.max(pathSum(root.left, diff), pathSum(root.left, targetSum));
        int right = Math.max(pathSum(root.right, diff),pathSum(root.right, targetSum));

        return left + right;
    }
}