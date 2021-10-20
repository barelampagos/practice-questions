/**
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.

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
    int length;
    List<Integer> values;
    
    public Solution(ListNode head) {
        length = 0;
        values = new ArrayList<>();

        ListNode curr = head;
        
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        
        length = values.size();
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt((length - 1) + 1);
        int randomNum = values.get(randomIndex);
        System.out.println(randomNum);
        return randomNum;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */