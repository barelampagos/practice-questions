/**
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr == head && curr.val == val) {
                // Case: head match --> update head               
                head = curr.next;
                curr = head;
            } else if (curr.val == val && curr.next == null) {
                // Case: remove tail
                prev.next = null;
                curr = null;
            } else if (curr.val == val) {
                // Case remove mid
                prev.next = curr.next;
                curr = curr.next;
            } else {
                // case no match
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}