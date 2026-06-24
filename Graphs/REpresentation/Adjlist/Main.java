import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of nodes
        int n = sc.nextInt(); 
        // number of edges
        int m = sc.nextInt(); 

        // Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // For undirected graph
            adj[u].add(v);
            adj[v].add(u);
        }

        System.out.println("Adjacency List:");
for (int i = 1; i <= n; i++) {
    System.out.print(i + " -> ");
    System.out.println(adj[i]);
}
        sc.close();
    }
}
