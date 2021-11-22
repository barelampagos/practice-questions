/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 * 
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
 */

 function hasPathSum(root: TreeNode | null, targetSum: number): boolean {    
    if (root == null) {
        return false;
    }
    
    if (root.val == targetSum && root.left == null && root.right == null) {
        return true;
    }
    
    let leftRec: boolean = hasPathSum(root.left, targetSum - root.val);
    let rightRec: boolean = hasPathSum(root.right, targetSum - root.val);
    
    return leftRec || rightRec;
};