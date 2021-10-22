/**
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
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
    public void flatten(TreeNode root) {
        // Tree traversal --> store the values in a queue
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        
        TreeNode curr = queue.poll();
                
        while (!queue.isEmpty()) {
            TreeNode child = queue.poll();
            
            if (child == curr) {
                continue;
            }
            System.out.println("CURR CHILD: " + child.val);
            curr.left = null;
            curr.right = child;
            curr = curr.right;
        }
    }
    
    public static void preOrder(TreeNode root, Queue<TreeNode> queue) {
        if (root != null) {
            queue.add(root);
            preOrder(root.left, queue);
            preOrder(root.right, queue);
        }
    }
    
}