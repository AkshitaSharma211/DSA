class Solution {
    int rows, cols;
    public int numEnclaves(int[][] grid) {
        rows = grid.length; cols = grid[0].length;

        for(int r = 0; r < rows; r++) {
            markLand(grid, r, 0);
            markLand(grid, r, cols-1);
        }

        for(int c = 0; c < cols; c++) {
            markLand(grid, 0, c);
            markLand(grid, rows-1, c);
        }

        int enclaves = 0;
        for(int[] row: grid) 
            for(int e : row) 
                enclaves += e;
        
        return enclaves;
    }

    private void markLand(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) return;
        grid[r][c] = 0;
        if(r+1 < rows && grid[r+1][c] != 0)
            markLand(grid, r + 1, c);
        if(r-1 >= 0 && grid[r-1][c] != 0)
            markLand(grid, r - 1, c);
        if(c+1 < cols && grid[r][c+1] != 0)
            markLand(grid, r, c + 1);
        if(c-1 > 0 && grid[r][c-1] != 0)
            markLand(grid, r, c - 1);
    }
public static void main(String[] args){
    Solution s = new Solution();
    int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
    System.out.println(s.numEnclaves(grid));  // should print 3
}

}