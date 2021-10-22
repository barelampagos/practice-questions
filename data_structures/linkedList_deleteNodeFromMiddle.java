/**
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        
        while (curr.next.next != null) {
            curr.val = curr.next.val;
            curr = curr.next;
        }
        
        // Assign last val and break link
        curr.val = curr.next.val;
        curr.next = null;
    }
}

/* 4 - 1 - 9 - 9

[1,2,4], node = 3

Input: head = [1], node = 0



head = [5,-99], node = -3

    
*/