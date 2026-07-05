import java.util.*;

class Solution {
    List<int[]> currentIsland;

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    currentIsland = new ArrayList<>();
                    dfs(i, j, i, j, visited, grid, m, n);
                    set.add(Arrays.deepToString(currentIsland.toArray()));
                }
            }
        }
        return set.size();
    }

    void dfs(int row, int col, int baseRow, int baseCol,
             boolean[][] visited, int[][] grid, int m, int n) {

        if (row < 0 || col < 0 || row >= m || col >= n ||
            visited[row][col] || grid[row][col] == 0)
            return;

        visited[row][col] = true;

        currentIsland.add(new int[]{row - baseRow, col - baseCol});

        dfs(row-1, col, baseRow, baseCol, visited, grid, m, n);
        dfs(row+1, col, baseRow, baseCol, visited, grid, m, n);
        dfs(row, col-1, baseRow, baseCol, visited, grid, m, n);
        dfs(row, col+1, baseRow, baseCol, visited, grid, m, n);
    }
}

class Main {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };

        System.out.println(obj.numDistinctIslands(grid));
    }
}