/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        
        ListNode sumHead = null;
        ListNode sumCurr = null;
        
        int carryOver = 0;
        
        while (l1Curr != null || l2Curr != null || carryOver > 0) {
            // Handle summation
            int currSum = (l1Curr != null ? l1Curr.val : 0) + (l2Curr != null ? l2Curr.val : 0);
            
            if (carryOver > 0) {
                currSum += carryOver;
                carryOver = 0;
            }
            
            if (currSum >= 10) {
                currSum = currSum - 10;
                carryOver = 1;
            }
            
            // Set node in LL
            ListNode newNode = new ListNode(currSum);
            if (sumHead == null) {
                sumHead = newNode;
                sumCurr = newNode;
            } else {
                sumCurr.next = newNode;
                sumCurr = sumCurr.next;
            }
            
            // Iterate
            l1Curr = l1Curr != null ? l1Curr.next : null;
            l2Curr = l2Curr != null ? l2Curr.next : null;
        }
        
        return sumHead;
    }
}