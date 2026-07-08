import java.util.*;

public class CS2 {

    public int[] findOrder(int N, int[][] arr) {

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];

        // Build graph
        for (int[] edge : arr) {
            int a = edge[0];
            int b = edge[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        // Add all nodes with indegree 0
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[N];
        int idx = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            topo[idx++] = node;

            for (int nei : adj.get(node)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (idx != N) {
            return new int[0]; // Cycle exists
        }

        return topo;
    }

    public static void main(String[] args) {

        CS2 obj = new CS2();

        int N = 4;

        int[][] arr = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] ans = obj.findOrder(N, arr);

        if (ans.length == 0) {
            System.out.println("Cycle exists. No valid ordering.");
        } else {
            System.out.print("Topological Order: ");
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}