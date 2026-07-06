import java.util.*;

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] colour = new int[n];

        Arrays.fill(colour, -1);

        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                if (!dfs(i, 0, colour, graph))
                    return false;
            }
        }

        return true;
    }

    boolean dfs(int node, int col, int[] colour, int[][] graph) {

        colour[node] = col;

        for (int it : graph[node]) {

            if (colour[it] == -1) {
                if (!dfs(it, 1 - col, colour, graph))
                    return false;
            } else if (colour[it] == col) {
                return false;
            }
        }

        return true;
    }
}

public class Bipartite {

    public static void main(String[] args) {

        Solution obj = new Solution();

        // Example 1 (Bipartite)
        int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        System.out.println(obj.isBipartite(graph1)); // true

        // Example 2 (Not Bipartite)
        int[][] graph2 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println(obj.isBipartite(graph2)); // false
    }
}