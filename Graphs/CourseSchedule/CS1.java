import java.util.*;

class Solution {

    public boolean canFinish(int N, int[][] arr) {

        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];

        // Build graph and indegree array
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

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;

                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return count == N;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int N = 4;

        int[][] arr = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        boolean ans = obj.canFinish(N, arr);

        System.out.println(ans);
    }
}