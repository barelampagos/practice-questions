/**
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Naive solution: 
        //         double pow = 0;
        //         double num = Math.pow(2, pow);

        //         while (num <= n) {
        //             if (num == n) {
        //                 return true;
        //             }

        //             pow++;
        //             num = Math.pow(2, pow);
        //         }
        // return false;
        
        // Bitwise operation:
        /**
        Let’s say n is 8. Its binary representation will be : 1000.
        binary represetation of 7 will be : 0111.
        1 0 0 0 & 0 1 1 1 == 0 0 0 0
         */
        if (n <= 0)
            return false;

        return (n & n-1) == 0;
    }
    
    // 1, 2, 4, 8, 16, 32, 64, 128
}