/**
 * 
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
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
 */

 function levelOrderBottom(root: TreeNode | null): number[][] {
    let queue: TreeNode[] = [];
    let results: number[][] = [];
    let currLevel: number[] = [];
    
    if (root != null) {
        queue.unshift(root);
    }
    
    while (queue.length > 0) {
        let currLevelSize: number = queue.length;
        currLevel = [];
        
        for (let i = 0; i < currLevelSize; i++) {
            let curr: TreeNode = queue.shift();
            currLevel.push(curr.val);
            
            if (curr.left != null) {
                queue.push(curr.left);
            }
            
            if (curr.right != null) {
                queue.push(curr.right);
            }
        }
        // Add to front of list
        results.unshift(currLevel);
    }
    
    return results;
};