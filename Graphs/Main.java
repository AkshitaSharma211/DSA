import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of nodes
        int n = sc.nextInt(); 
        // number of edges
        int m = sc.nextInt(); 

        // adjacency matrix
        int[][] adj = new int[n + 1][n + 1]; 

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            // remove this line in case of directed graph
            adj[v][u] = 1; 
        }


        System.out.println("Adjacency Matrix:");
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        System.out.print(adj[i][j] + " ");
    }
    System.out.println();
}

        sc.close();
    }
}
