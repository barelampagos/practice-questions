
/**
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
*/
class Solution {
    class Coordinate {
        
        int row;
        int col;
        
        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return (row == that.row) &&
              (col == that.col);
        }
        
        @Override
        public String toString() {
            return "[" + row + "," + col + "]";
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        HashMap<Integer, List<Integer>> visited = new HashMap<>();
        
        int startingColor = image[sr][sc];
        queue.add(new Coordinate(sr, sc));
        
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            
            // System.out.println();
            // System.out.println("ROW: " + curr.row);
            // System.out.println("COL: " + curr.col);
            
            int row = curr.row;
            int col = curr.col;
            
            //System.out.println(Arrays.toString(visited.toArray()));
            
            if (visited.containsKey(row) && visited.get(row).contains(col)) {
                continue;
            } 
            
            // Add to visited & enqueue those around it
            if (visited.containsKey(row)) {
                visited.get(row).add(col);
            } else {
                List<Integer> cols = new ArrayList<Integer>();
                cols.add(col);
                visited.put(row, cols);
            }
                        
            if (image[row][col] == startingColor) {
                image[row][col] = newColor;
            }
            
            // Up and Down
            if (row + 1 < image.length && image[row + 1][col] == startingColor)
                queue.add(new Coordinate(row + 1, col));
            
            if (row - 1 >= 0 && image[row - 1][col] == startingColor)
                queue.add(new Coordinate(row - 1, col));
            
            // Left and Right
            if (col + 1 < image[0].length && image[row][col + 1] == startingColor)
                queue.add(new Coordinate(row, col + 1));
            
            if (col - 1 >= 0 && image[row][col - 1] == startingColor)
                queue.add(new Coordinate(row, col - 1));
        }
        
        return image;
    }
}