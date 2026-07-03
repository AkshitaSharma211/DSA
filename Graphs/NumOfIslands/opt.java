import java.util.*;
class Solution {

    int rows, cols, count;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        count = 0;

        for(int i=0;i<rows;i++){
            check(i, grid);
        }

        return count;
    }


    void check(int i, char[][] grid){

        for(int j=0;j<cols;j++){

            if(grid[i][j]=='1'){
                count++;
                dfs(i,j,grid);
            }
        }
    }


    private void dfs(int i,int j,char[][] grid){

        grid[i][j]='0'; //mark visited


        // up
        if(i-1>=0 && grid[i-1][j]=='1')
            dfs(i-1,j,grid);

        // down
        if(i+1<rows && grid[i+1][j]=='1')
            dfs(i+1,j,grid);

        // left
        if(j-1>=0 && grid[i][j-1]=='1')
            dfs(i,j-1,grid);

        // right
        if(j+1<cols && grid[i][j+1]=='1')
            dfs(i,j+1,grid);
    }
    public static void main(String[] args){
    Solution s = new Solution();
    char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
    System.out.println(s.numIslands(grid));  // should print 1
}
}