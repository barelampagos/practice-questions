/**
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Generate output matrix (same dimensions)
        int[][] result = new int[mat.length][mat[0].length];
        
        // For each cell:
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                int currCellVal = mat[row][col];
                
                // If value = 0 --> output val = 0
                if (currCellVal == 0) {
                    result[row][col] = currCellVal;
                } else {
                    // If value is 1 --> search nearby cells for 0
                    int radius = 1;
                    boolean zeroFound = false;
                    
                    while (!zeroFound) {
                        int searchVal = 0;
                        
                        // Check border around cell -- Search nearby:
                        for (int searchCol = col - radius; searchCol <= col + radius; searchCol++) {
                            for (int searchRow = row - radius; searchRow <= row + radius; searchRow++) {
                                System.out.println("Searching MAT[" + searchRow + "][" + searchCol + "]");                                               

                                // Check if out of bounds
                                if ((searchRow >= mat.length || searchRow < 0) || (searchCol >= mat[0].length || searchCol < 0)) 
                                    continue;

                                searchVal = mat[searchRow][searchCol];
                                System.out.println("SEARCH VAL: " + searchVal);

                                if (searchVal == 0) {
                                    System.out.println("ZERO FOUND -- BREAKING");
                                    
                                    int distance = Math.abs(searchRow - row) + Math.abs(searchCol - col);
                                    System.out.println(distance);
                                    
                                    // Diagonal check
                                    //boolean topLeft = searchRow + distance == row && searchCol + distance == col;
                                    //boolean topRight = searchRow + distance == row && searchCol - distance == col;

                                    //boolean botLeft = searchRow - distance == row && searchCol + distance == col;
                                    //boolean botRight = searchRow - distance == row && searchCol - distance == col;

                                    //if (topLeft || topRight || botLeft || botRight) {
                                    //     distance++;
                                    //}
                                    
                                    if (result[row][col] == 0) {
                                        result[row][col] = distance;
                                    } else {
                                        // Keep minimum value
                                        result[row][col] = Math.min(distance, result[row][col]);
                                    }
                                    
                                    zeroFound = true;
                                }
                            }
                        }
                        
                        // Not found? Increment distance
                        radius++;
                    }

                }
                
            }
        }
        
        return result;
    }
}

// COL 1:
// Top left [row - 1][col - 1]
// left [row][col - 1]
// bottom left [row + 1][col - 1]

// COL 2:
// Top [row - 1][col]
// bottom [row + 1][col]

// COL 3:
// Top right [row - 1][col + 1]
// right [row][col + 1]
// bottom right [row + 1][col + 1]