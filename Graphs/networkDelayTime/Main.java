import java.util.*;

class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency List: {neighbor, time}
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k - 1] = 0;

        // {time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, k - 1});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int node = curr[1];

            // Skip outdated entry
            if (time > dist[node])
                continue;

            // Explore neighbors
            for (int[] edge : adj.get(node)) {

                int nextNode = edge[0];
                int edgeWt = edge[1];

                int nextTime = time + edgeWt;

                if (nextTime < dist[nextNode]) {

                    dist[nextNode] = nextTime;

                    pq.add(new int[]{nextTime, nextNode});
                }
            }
        }

        int maxTime = 0;

        for (int d : dist) {

            if (d == Integer.MAX_VALUE)
                return -1;

            maxTime = Math.max(maxTime, d);
        }

        return maxTime;
    }
}

public class Main {

    public static void main(String[] args) {

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        Solution obj = new Solution();

        int ans = obj.networkDelayTime(times, n, k);

        System.out.println("Network Delay Time = " + ans);
    }
}