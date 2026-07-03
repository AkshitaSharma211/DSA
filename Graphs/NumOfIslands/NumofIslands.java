import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int count=0;
        boolean[][] visited= new boolean[m][n];


    for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
        if(grid[i][j] == '1' && !visited[i][j]){
            count++;
            dfs(i, j, visited, grid, m, n);
        }
    }
}
return count;
    }

    void dfs(int row, int col, boolean[][] visited, char[][] grid, int m, int n){
        visited[row][col] = true;
        int[] dr= {-1,1,0,0};
        int[] dc= {0,0,-1,1};
        
        for(int d=0;d<4;d++){
            int nr= dr[d]+row;
            int nc= dc[d]+col;

            if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]=='1'){
                dfs(nr,nc,visited, grid,m,n);
            }
        }
        
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
