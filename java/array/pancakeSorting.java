/**
NOTE: Incomplete solution

Pancake Sorting:
Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

Example 1:

Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
 */
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        // Setup sorted array for loop comparison
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        System.out.println("SORTED EXPECTATION: " + Arrays.toString(sortedArray));

        // Loop until arr is sorted --> when is array sorted?
        while (!arr.equals(sortedArray)) {
            int k = 0;
            
            // Random int (1 -> arr.length)
            int range = (arr.length - 1) + 1;
            int random = (int) (Math.random() * range) + 1;             
            k = random;
            
            // Perform our flip
            System.out.println("K: " + k);
            pancakeFlip(k, arr);
            result.add(k);
        }
        
        return result;
    }
    
    // Flip:
    // Choose int k where 1 <= k <= arr.length
    // Reverse sub array arr[0, k-1] 
    private static void pancakeFlip(int k, int[] arr) {
        System.out.println("BEGIN: " + Arrays.toString(arr));
        
        int startIndex = 0;
        int endIndex = k - 1;
        
        int temp = 0;
        
        while (startIndex < endIndex) {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            
            startIndex++;
            endIndex--;
        }
        
        System.out.println("AFTER FLIP: " + Arrays.toString(arr));
    }
}

/* 
arr = [3, 2, 4, 1]

k = 4 <-- found min (1) at spot #4
[1, 4, 2, 3]

k = 2 <-- max at spot #2
[4, 1, 2, 3]

k = 4 <-- 2nd max at spot #4
[3, 2, 1, 4]

k = 3 <-- min at spot #3
[1, 2, 3, 4]

Return array(List?) of k values that would sort arr
VALID: Sort array within 10 * arr.length flips
*/