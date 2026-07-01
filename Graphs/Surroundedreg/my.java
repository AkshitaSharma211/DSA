import java.util.*;
class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited= new boolean[m][n];
       for(int j=0;j<n;j++){
       if(board[0][j]=='O') {
        q.add(new int[]{0,j});
        visited[0][j]= true;
       }
       } 

      for(int j=0;j<n;j++){
       if(board[m-1][j]=='O') {
        q.add(new int[]{m-1,j});
        visited[m-1][j]= true;
       }
       }

       for(int i=0;i<m;i++){
       if(board[i][0]=='O') {
        q.add(new int[]{i,0});
        visited[i][0]= true;
       }
       }
      
       for(int i=0;i<m;i++){
       if(board[i][n-1]=='O') {
        q.add(new int[]{i,n-1});
        visited[i][n-1]= true;
       }
       }

    bfs(visited, q,board, m,n);
    for(int i = 0; i < m; i++)
    for(int j = 0; j < n; j++)
        if(board[i][j]=='O' && !visited[i][j])
            board[i][j]='X';
   
    }

    void bfs( boolean[][] visited, Queue<int[]> q, char[][] board, int m, int n){
        while(!q.isEmpty()){
           int[]curr= q.poll();
            int row= curr[0];
            int col= curr[1];
           int[] dr={-1,1,0,0};
           int[] dc={0,0,-1,1};

           for(int d=0; d<4; d++){
           int nr= dr[d]+ row;
            int nc= dc[d]+ col;
           
           
          if(nc>=0 && nc<n && nr>=0 && nr<m && board[nr][nc]=='O' && !visited[nr][nc]){
            q.add(new int[]{nr,nc});
            visited[nr][nc]= true;
          
        }

           }
        }
    }
    public static void main(String[] args){
    Solution s = new Solution();
    char[][] board = {
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
    };
    s.solve(board);
    for(char[] row : board)
        System.out.println(new String(row));
}
}