/**
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> diffMap;
    
    public boolean findTarget(TreeNode root, int k) {
        // Map <Diff, Root val>
        diffMap = new HashMap<>();
        return iterateTree(root, k);
    }
    
    public boolean iterateTree(TreeNode root, int k) {
        // Iterate through the BST
        if (root == null) 
            return false;
        
        //System.out.println("CURR: " + root.val);

        // Check if root.val in Map
        if (diffMap.containsKey(root.val)) {
            return true;
        }

        // Else - calculate diff & add to map
        int currDiff = k - root.val;
        diffMap.put(currDiff, root.val);

        return iterateTree(root.left, k) || iterateTree(root.right, k);
    }
}