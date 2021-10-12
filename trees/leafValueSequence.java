/**
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Generate a sequence of leaf values for a tree
        List<Integer> root1Leaves = generateLeafValues(root1);
        System.out.println(root1Leaves);
        
        List<Integer> root2Leaves = generateLeafValues(root2);
        System.out.println(root2Leaves);
        
        // Compare if tree 1 & 2 are the same
        return root1Leaves.equals(root2Leaves);
    }
    
    private List<Integer> generateLeafValues(TreeNode tree) {
        List<Integer> leafValues = new ArrayList<>();
        
        if (tree != null) {
            //System.out.println(tree.val);
            
            List<Integer> leftSide = generateLeafValues(tree.left);
            List<Integer> rightSide = generateLeafValues(tree.right);
            
            // Leaf
            if (leftSide == null && rightSide == null) {
                leafValues.add(tree.val);    
            } else {
                if (leftSide != null)
                    leafValues.addAll(leftSide);
                
                if (rightSide != null)
                    leafValues.addAll(rightSide);
            }
        } else {
            return null;
        }
        
        return leafValues;
    }
}