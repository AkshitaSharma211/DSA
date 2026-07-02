import java.util.*;
class Solution {
    public int[][] nearest(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] result = new int[m][n];
       Queue<int[]> q= new LinkedList<>();
       boolean[][] visited= new boolean[m][n];

       for(int i=0;i<m;i++){
        for(int j=0;j< n;j++){
            if(grid[i][j]==1){
                q.add(new int[]{i,j,0});
                visited[i][j]= true;
            }

        }
       }
       bfs(q,visited,grid,m,n,result);

       return result;
    }

void bfs(Queue<int[]> q,boolean[][] visited, int[][] grid,int m, int n, int[][] result){
    
    while(!q.isEmpty()){
    int[] curr= q.poll();
    int row= curr[0];
    int col= curr[1];
    int count= curr[2];

    int[] dr= {-1,1,0,0};
    int[] dc= {0,0,-1,1};

    for(int d=0;d<4;d++){
        int nr= dr[d]+row;
        int nc= dc[d]+col;
        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0 && !visited[nr][nc]){
          result[nr][nc]= count+1;
          q.add(new int[]{nr,nc,count+1});
          visited[nr][nc]=true;


        }
    }
    }
}

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] grid = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = s.nearest(grid);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}