/**
 * 
 * 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
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

 function levelOrder(root: TreeNode | null): number[][] {
    let results: number[][] = [];
    let queue: TreeNode[] = [];
    let currentLevelNodes: number[] = [];
  
    if (root != null) {
        queue.unshift(root);
    }
    
    while (queue.length > 0) {
        //console.log(currNode.val)        
        let numOnLevel: number = queue.length
        currentLevelNodes = [];
        
        for (let i = 0; i < numOnLevel; i++) {
            let currNode = queue.shift();
            currentLevelNodes.push(currNode.val);
            
            if (currNode.left != null) {
                queue.push(currNode.left);
            }
        
            if (currNode.right != null) {
                queue.push(currNode.right);
            }
        }
        
        results.push(currentLevelNodes);
    }
    
    return results;
};