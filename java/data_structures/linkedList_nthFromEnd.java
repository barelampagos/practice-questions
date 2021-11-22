/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nTH = head;
        
        for (int i = 0; i < n; i++) {
            nTH = nTH.next;
        }
        
        while (nTH != null) {
            prev = curr;
            curr = curr.next;
            nTH = nTH.next;
        }
        
        System.out.println(curr.val);
        
        if (prev != null) {
            prev.next = curr.next;
            curr.next = null;
        } else if (curr == head && curr.next == null) {
            head = null;
        } else if (curr == head && curr.next != null) {
            head = curr.next;
            curr.next = null;
        }
        
        return head;
    }
}