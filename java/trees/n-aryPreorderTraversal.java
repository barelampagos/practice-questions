/**

589. N-ary Tree Preorder Traversal

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
 
 */

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        
        if (root != null) {
            results.add(root.val);
            //System.out.println(root.val);

            for (Node child : root.children) {
                results.addAll(preorder(child));
                //preorder(child);
            }
        }
        
        return results;
    }
}