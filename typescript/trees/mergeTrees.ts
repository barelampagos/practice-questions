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
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
 */

 function mergeTrees(root1: TreeNode | null, root2: TreeNode | null): TreeNode | null {
    console.log('\nRECURSE')
    console.log("R1: " + (root1 != null ? root1.val : 'NULL'))
    console.log("R2: " + (root2 != null ? root2.val : 'NULL'))
    
    if (root1 == null && root2 != null) {
        return root2;
    } else if (root1 != null && root2 == null) {
        return root1;
    } else if (root1 == null && root2 == null) {
        return null;
    }
    
    let leftRec: TreeNode = mergeTrees(root1.left, root2.left);
    let rightRec: TreeNode = mergeTrees(root1.right, root2.right);
    let currRoot: TreeNode = new TreeNode((root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0));
    
    currRoot.left = leftRec;
    currRoot.right = rightRec;
    
    return currRoot;
};