/**
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Detect loop ?
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        // No loop detected
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // Loop detected, get len of cycle
        int loopLen = 1;
        fast = fast.next;
        
        while (fast != slow) {
            fast = fast.next;
            loopLen++;
        }
        
        // Reset ptrs 
        slow = head;
        fast = head;
        
        // move K elements down
        while (loopLen > 0) {
            fast = fast.next;
            loopLen--;
        }
        
        // iterate until equal
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}