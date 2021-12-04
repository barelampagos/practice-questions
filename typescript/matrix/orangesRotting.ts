/**
 * 
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
 */
class Cell {
    row: number;
    col: number;

    constructor(row: number, col: number) {
        this.row = row;
        this.col = col;
    }
}

function orangesRotting(grid: number[][]): number {
    // BFS (Queue)
    let visited: boolean[][] = initVisited(grid.length, grid[0].length);
    let minutes: number = 0;
    let freshOranges: number = 0;
    let queue: Cell[] = [];
    
    // Iterate through matrix, add any rotten oranges (2), keep track of num of fresh oranges
    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            let curr: number = grid[row][col];
            
            if (curr == 1) {
                freshOranges++;
            } else if (curr == 2) {
                // Add to queue
                queue.push(new Cell(row, col));
            }
        }
    }
    
    // Check size of queue (represents current minute = 0 -> end) 
    while (queue.length > 0) {
        let sizeForMin: number = queue.length;
        
        for (let i = 0; i < sizeForMin; i++) {
            let currCell: Cell = queue.shift();
            let currRow: number = currCell.row;
            let currCol: number = currCell.col;
            console.log('CURR: ' + currRow + ', ' + currCol)
            
            if (visited[currRow][currCol]) {
                continue;
            }
            
            // If not rotten, convert to rotten (decrement oranges)
            if (grid[currRow][currCol] == 1) {
                grid[currRow][currCol] = 2;
                freshOranges--;
            }
            
            // Add all adjacent fresh
            // Check up
            if (currRow - 1 >= 0 && grid[currRow - 1][currCol] == 1) {
                queue.push(new Cell(currRow - 1, currCol));
            }
            
            // down
            if (currRow + 1 < grid.length && grid[currRow + 1][currCol] == 1) {
                queue.push(new Cell(currRow + 1, currCol));
            }
            
            // left
            if (currCol - 1 >= 0 && grid[currRow][currCol - 1] == 1) {
                queue.push(new Cell(currRow, currCol - 1));
            }
            
            // right
            if (currCol + 1 < grid[0].length && grid[currRow][currCol + 1] == 1) {
                queue.push(new Cell(currRow, currCol + 1));
            }
            
            // Mark visited
            visited[currRow][currCol] = true;
        }
        
        if (freshOranges == 0) {
            break;
        } else {
            minutes++;
        }
    }
    
    return freshOranges == 0 ? minutes : -1;
};
    
function initVisited(m: number, n: number): boolean[][] {
    let visited: boolean[][] = [];
    
    for (let row = 0; row < m; row++) {
        visited[row] = [];
        for (let col = 0; col < n; col++) {
            visited[row].push(false)
        }
    }
    
    //console.log(visited);
    return visited;
}