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
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

Example 1:
Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]

 */

 function trimBST(root: TreeNode | null, low: number, high: number): TreeNode | null {
    if (root == null) {
        return null;
    }
    
    let leftChild: TreeNode = trimBST(root.left, low, high);
    let rightChild: TreeNode = trimBST(root.right, low, high);
    
    root.left = leftChild;
    root.right = rightChild;
    
    if (root.val < low || root.val > high) {
        // Remove (root is null)
        root = leftChild != null ? leftChild : rightChild;
    }
    
    return root;
};


/**

[1,0,2]
1
2

**/