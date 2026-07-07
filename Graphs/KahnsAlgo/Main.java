import java.util.*;

class Solution {
    // Function to detect cycle in a directed graph using Kahn's Algorithm
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        // Store in-degrees of all nodes
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Queue for nodes with 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // Count visited nodes
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            // Reduce in-degree of neighbors
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If count != V, cycle exists
        return count != V;
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Solution obj = new Solution();
        if (obj.hasCycle(V, adj))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycle");
    }
}
