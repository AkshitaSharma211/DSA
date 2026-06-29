import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        
    int total_oranges=0;
    List<List<Integer>> queue = new ArrayList<>();
    int total_time=0;
    int count=0;
    int initial_rotten=0;

    for(int i=0; i<grid.length; i++){
        for(int j=0; j<grid[0] .length; j++){
            if((grid[i][j]==1) || (grid[i][j]==2))
            total_oranges++;
            if(grid[i][j]==2){
                queue.add(Arrays.asList(i,j));
                initial_rotten++;
            }
        }
    }
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                List<Integer> curr = queue.remove(0);
int row = curr.get(0);
int col = curr.get(1);

int[] dr = {-1, 1, 0, 0};  // up, down, left, right
int[] dc = {0, 0, -1, 1};

for(int d = 0; d < 4; d++){
    int nr = row + dr[d];
    int nc = col + dc[d];
    
    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
        grid[nr][nc] = 2;  // make it rotten
        count++;
        queue.add(Arrays.asList(nr, nc));
    }
}
            }
            total_time++;
        
    }

    if(count + initial_rotten == total_oranges)
    return total_time;
else
    return -1;  // some fresh oranges unreachable



    }
public static void main(String[] args){
    Solution s = new Solution();
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    System.out.println(s.orangesRotting(grid));  // should print 4
}

}


