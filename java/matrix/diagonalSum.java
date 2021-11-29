/**
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int diagSum = 0;
        int currRow = 0;
        int currCol = 0;
        
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        // Sum primary diagonal
        int primaryDiag = 0;
        
        while (currRow < mat.length && currCol < mat[0].length) {
            int curr = mat[currRow][currCol];
            System.out.println(curr);
            
            if (!visited[currRow][currCol]) {
                primaryDiag += curr;    
                visited[currRow][currCol] = true;
            }
                        
            currRow++;
            currCol++;
        }
        
        // Sum secondary diagonal
        int secondaryDiag = 0;
        
        if (mat.length > 1) {
            currRow = 0;
            currCol = mat[0].length - 1;
            
            while (currRow < mat.length && currCol >= 0) {
                int curr = mat[currRow][currCol];
                System.out.println(curr);
                
                if (!visited[currRow][currCol]) {
                    secondaryDiag += curr;
                    visited[currRow][currCol] = true;
                }

                currRow++;
                currCol--;
            }
        }
        
        diagSum += primaryDiag + secondaryDiag;
        
        return diagSum;
    }
}