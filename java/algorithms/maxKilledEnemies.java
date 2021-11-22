/**
Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.

The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.

Example 1:

Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
*/
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int maxDead = 0;
        int currDead = 0;
        
        // Iterate each cell
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                currDead = 0;
                
                // Only proceed if empty
                char curr = grid[row][col];
                if (curr != '0')
                    continue;
                
                // Iterate row (up & down)
                for (int currRow = row - 1; currRow >= 0; currRow--) {
                    if (grid[currRow][col] == 'E') {
                        currDead++;
                    } else if (grid[currRow][col] == 'W') {
                        // No need to continue looking through
                        break;
                    }
                }
                
                for (int currRow = row + 1; currRow < grid.length; currRow++) {
                    if (grid[currRow][col] == 'E') {
                        currDead++;
                    } else if (grid[currRow][col] == 'W') {
                        // No need to continue looking through
                        break;
                    }
                }
                
                // Iterate col (left & right)
                for (int currCol = col - 1; currCol >= 0; currCol--) {
                    if (grid[row][currCol] == 'E') {
                        currDead++;
                    } else if (grid[row][currCol] == 'W') {
                        // No need to continue looking through
                        break;
                    }
                }
                
                for (int currCol = col + 1; currCol < grid[0].length; currCol++) {
                    if (grid[row][currCol] == 'E') {
                        currDead++;
                    } else if (grid[row][currCol] == 'W') {
                        // No need to continue looking through
                        break;
                    }
                }
                
                maxDead = Math.max(currDead, maxDead);
            }
        }
        
        return maxDead;
    }
}