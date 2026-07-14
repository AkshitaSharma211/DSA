import java.util.*;

class Tuple {
    int distance;
    int row;
    int col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        // Min Heap -> {effort, row, col}
        PriorityQueue<Tuple> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance);

        // Distance/Effort array
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        pq.offer(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Tuple curr = pq.poll();

            int effort = curr.distance;
            int row = curr.row;
            int col = curr.col;

            // Skip outdated entries
            if (effort > dist[row][col])
                continue;

            // Destination reached
            if (row == n - 1 && col == m - 1)
                return effort;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m) {

                    int edgeEffort = Math.abs(
                            heights[row][col] - heights[newRow][newCol]);

                    int newEffort = Math.max(effort, edgeEffort);

                    if (newEffort < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newEffort;

                        pq.offer(new Tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }

        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        Solution obj = new Solution();

        int ans = obj.minimumEffortPath(heights);

        System.out.println("Minimum Effort = " + ans);
    }
}