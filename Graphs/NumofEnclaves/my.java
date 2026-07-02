import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
     int m= grid.length;
     int n= grid[0].length;
     boolean[][] visited= new boolean[m][n];
    
            for(int j = 0; j < n; j++){
    if(grid[0][j] == 1 && !visited[0][j]) dfs(0, j, visited, m, n, grid);
    if(grid[m-1][j] == 1 && !visited[m-1][j]) dfs(m-1, j, visited, m, n, grid);
}

for(int i = 0; i < m; i++){
    if(grid[i][0] == 1 && !visited[i][0]) dfs(i, 0, visited, m, n, grid);
    if(grid[i][n-1] == 1 && !visited[i][n-1]) dfs(i, n-1, visited, m, n, grid);
}
 int count = 0;
for(int i = 0; i < m; i++)
    for(int j = 0; j < n; j++)
        if(grid[i][j] == 1 && !visited[i][j])
            count++;
return count;
        
    }
void dfs(int row,int col,boolean[][] visited, int m, int n,int[][] grid){
    visited[row][col]= true;
   int[] dr= {-1,1,0,0};
   int[] dc={0,0,-1,1};

   for(int d=0;d<4;d++){
    int nr= dr[d]+row;
    int nc=dc[d]+col;

    if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]==1){
        dfs(nr,nc, visited, m,n,grid);
    }

   
   }    
    }

    public static void main(String[] args){
    Solution s = new Solution();
    int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
    System.out.println(s.numEnclaves(grid));  // should print 3
}
}

