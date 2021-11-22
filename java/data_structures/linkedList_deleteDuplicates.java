/**

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        // 2 Pass solution ?  1. Count duplicates, 2. Remove duplicates
        HashMap<Integer, Integer> nodeCountMap = new HashMap<>();
        while (curr != null) {
            if (nodeCountMap.containsKey(curr.val)) {
                nodeCountMap.put(curr.val, nodeCountMap.get(curr.val) + 1);                
            } else {
                nodeCountMap.put(curr.val, 1);                
            }
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            int nodeCount = nodeCountMap.get(curr.val);
            
            if (nodeCount > 1) {
                // Walk to non duplicate num
                for (int numNodes = 0; numNodes < nodeCount; numNodes++) {
                    curr = curr.next;
                }
                
                if (prev == null) {
                    head = curr;
                } else {
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}