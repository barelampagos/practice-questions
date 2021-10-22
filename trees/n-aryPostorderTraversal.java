/*
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> traversal = new ArrayList<>();
                
        if (root != null) {
            if (root.children.size() > 0) {
                List<Integer> childrenVals = new ArrayList<>();
                
                for (int i = 0; i < root.children.size(); i++) {
                    childrenVals.addAll(postorder(root.children.get(i)));
                }
                
                traversal.addAll(childrenVals);
                traversal.add(root.val);
            } else {
                traversal.add(root.val);
            }
        }
        
        return traversal;
    }
}