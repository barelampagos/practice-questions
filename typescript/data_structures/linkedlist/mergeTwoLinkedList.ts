/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 * 
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []
 */

 function mergeTwoLists(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let l1Ptr: ListNode = l1;
    let l2Ptr: ListNode = l2;
    
    let newHead: ListNode = null;
    let newCurr: ListNode = null;
    
    while (l1Ptr != null && l2Ptr != null) {
        if (l1Ptr.val <= l2Ptr.val) {
            // Add l1 node to new LL
            if (newHead == null) {
                newHead = l1Ptr;
                newCurr = newHead;
            }  else {
                newCurr.next = l1Ptr;
                newCurr = newCurr.next;
            }
            
            // increment l1Ptr
            l1Ptr = l1Ptr.next;
        } else {
            // Add l2 node to new LL
            if (newHead == null) {
                newHead = l2Ptr;
                newCurr = newHead;
            } else {
                newCurr.next = l2Ptr;
                newCurr = newCurr.next;
            }
            
            // increment l2Ptr
            l2Ptr = l2Ptr.next;
        }    
    }
    
    while (l1Ptr != null) {
        // Add l1 node to new LL
        if (newHead == null) {
            newHead = l1Ptr;
            newCurr = newHead;
        }  else {
            newCurr.next = l1Ptr;
            newCurr = newCurr.next;
        }
        
        l1Ptr = l1Ptr.next;
    }
    
    while (l2Ptr != null) {
        // Add l2 node to new LL
        if (newHead == null) {
            newHead = l2Ptr;
            newCurr = newHead;
        } else {
            newCurr.next = l2Ptr;
            newCurr = newCurr.next;
        }
        
        l2Ptr = l2Ptr.next;
    }
    
    return newHead;
};