/**
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*/class Solution {
    class Cell {
        int row;
        int col;
        
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Stack<Cell> dfstack = new Stack<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col])
                    continue;
                
                if (grid[row][col] == 0) {
                    visited[row][col] = true;
                } else {
                    int currArea = 0;
                    dfstack.push(new Cell(row, col));
                    
                    while (!dfstack.isEmpty()) {
                        Cell curr = dfstack.pop();
                        if (visited[curr.row][curr.col])
                            continue;
                        
                        visited[curr.row][curr.col] = true;
                        
                        if (grid[curr.row][curr.col] == 1) {
                            //System.out.println("ROW: " + curr.row + ", COL: " + curr.col + "== 1");
                            currArea++;
                            
                            // Add above & below
                            if (curr.row + 1 < grid.length && !visited[curr.row + 1][curr.col])
                                dfstack.push(new Cell(curr.row + 1, curr.col));
                            
                            if (curr.row - 1 >= 0 && !visited[curr.row - 1][curr.col])
                                dfstack.push(new Cell(curr.row - 1, curr.col));
                            
                            // Add left & right
                            if (curr.col + 1 < grid[0].length && !visited[curr.row][curr.col + 1])
                                dfstack.push(new Cell(curr.row, curr.col + 1));
                            
                            if (curr.col - 1 >= 0 && !visited[curr.row][curr.col - 1])
                                dfstack.push(new Cell(curr.row, curr.col - 1));
                        }
                    }
                    
                    maxArea = Math.max(currArea, maxArea);
                }
                
            }
        }
        
        return maxArea;
    }
}

// [[1,1,0,0,0]
// ,[1,1,0,0,0]
// ,[0,0,0,1,1]
// ,[0,0,0,1,1]]