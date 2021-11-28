/**
Problem Statement#
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

Example 1:

Input: [3, 1, 5, 12, 2, 11], K = 3
Output: [5, 12, 11]
 */
public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    // Custom comparator
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, (a,b) -> b - a);

    for (int num : nums) {
      maxHeap.add(num);
    }

    ArrayList<Integer> results = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      results.add(maxHeap.poll());
    }

    return results;
}