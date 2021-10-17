/**
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 */
class KthLargest {
    private int k;
    private List<Integer> elements;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        elements = Arrays.stream(sortedNums).boxed().collect(Collectors.toList());
    }
    
    public int add(int val) {
        // Find proper insert index
        // Binary search insert
        int start = 0;
        int end = elements.size() - 1;
        int middle = 0;
        
        while (start <= end) {
            middle = start + (end - start) / 2;
            int curr = elements.get(middle);
            
            if (val >= curr) {
                start = middle + 1;
            } else if (val < curr) {
                end = middle - 1;
            }
        }
                
        elements.add(start, val);
        
        // Fetch current kth largest
        int kIndex = elements.size() - k;
        return elements.get(kIndex);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);

// Sorted input
[2, 4, 5, 8] (3rd largest = 4)

// add 3
[2, 3, 4, 5, 8] (3rd = 4)

// add 5
[2, 3, 4, 5, 5, 8] (3rd = 5)

// add 10
[2, 3, 4, 5, 5, 8, 10] (3rd = 5)

// add 9
[2, 3, 4, 5, 5, 8, 9, 10] (3rd = 8)

// add 4
[2, 3, 4, 4, 5, 5, 8, 9, 10] (3rd = 8)

// Ordered data structure

 */