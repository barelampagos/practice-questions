/**You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7] */

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let val1Digits: number[] = getNumbersFromList(l1);
    let val2Digits: number[] = getNumbersFromList(l2);
    
    let head: ListNode = null;
    let sum: number = 0;
    let remainder: number = 0;
    
    while (val1Digits.length > 0 || val2Digits.length > 0) {
        let val1: number = val1Digits.length > 0 ? val1Digits.pop() : 0;
        let val2: number = val2Digits.length > 0 ? val2Digits.pop() : 0;
        
        sum = val1 + val2;
        if (remainder > 0) {
            sum += remainder;
            remainder = 0;
        }
        
        // Set remainder
        if (sum >= 10) {
            sum -= 10;
            remainder = 1;
        }
        
        let newNode: ListNode = new ListNode(sum);
        
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    // Add leftover
    if (remainder > 0) {
        let newNode: ListNode = new ListNode(remainder);
        newNode.next = head;
        head = newNode;
    }
    
    return head;
}

function getNumbersFromList(head: ListNode): number[] {
    let numArray:number[] = []
    let curr: ListNode = head;
    
    while (curr != null) {
        numArray.push(curr.val);
        curr = curr.next;
    }
    
    return numArray;
}