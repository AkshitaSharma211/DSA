import java.util.*;

public class Solution {

    void topoSort(int node, boolean[] vis,
                  Stack<Integer> st,
                  List<List<int[]>> adj) {

        vis[node] = true;

        for (int[] edge : adj.get(node)) {
            int v = edge[0];

            if (!vis[v]) {
                topoSort(v, vis, st, adj);
            }
        }

        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new int[]{v, wt});
        }

        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!vis[i])
                topoSort(i, vis, st, adj);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);

        dist[0] = 0;     // source = 0

        while (!st.isEmpty()) {

            int node = st.pop();

            if (dist[node] != (int)1e9) {

                for (int[] edge : adj.get(node)) {

                    int adjNode = edge[0];
                    int wt = edge[1];

                    if (dist[node] + wt < dist[adjNode]) {
                        dist[adjNode] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == (int)1e9)
                dist[i] = -1;
        }

        return dist;
    }
    class Main {
    public static void main(String[] args) {

        int N = 6;
        int M = 7;

        // {source, destination, weight}
        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {4, 5, 4},
            {4, 2, 2},
            {1, 2, 3},
            {2, 3, 6},
            {5, 3, 1}
        };

        Solution obj = new Solution();

        int[] ans = obj.shortestPath(N, M, edges);

        System.out.println("Shortest distance from source (0):");

        for (int i = 0; i < N; i++) {
            System.out.println("Node " + i + " -> " + ans[i]);
        }
    }
}
}