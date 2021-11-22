/**
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

 */
class Solution {
    public int climbStairs(int n) {
        // Starting stair
        int[] memo = new int[n];
        return recurseStairs(0, n, memo);
    }
    
    public int recurseStairs(int start, int n, int[] memo) {
        // Exceeded n, not a valid step operation --> 0
        if (start > n) {
            return 0;
        }
        
        // Reached proper step (took 1 step)
        if (start == n) {
            return 1;
        }
        
        // Memoize previous results
        if (memo[start] > n) {
            return memo[start];
        }
        
        // Calculate every possible option (1 or 2)
        memo[start] = recurseStairs(start + 1, n, memo) + recurseStairs(start + 2, n, memo);
        return memo[start];
    }
}

/**

5
n - 1 = 4
    n - 1 = 3
        n - 1 = 2   --> 2
        n - 2 = 1   --> 1
    n - 2 = 2 --> 2
n - 2 = 3
    n - 1 = 2   --> 2
    n - 2 = 1   --> 1
    
*/