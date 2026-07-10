import java.util.*;

public class shortestPath {
    public int[] shortestPath(int[][] edges, int N, int M) {
 List<List<Integer>> adj= new ArrayList<>();
 for(int i=0;i<N;i++){
    adj.add(new ArrayList<>());}

for(int i=0;i<M;i++){
 int u=edges[i][0];
 int v=edges[i][1];
 adj.get(u).add(v);
 adj.get(v).add(u);
 }

 Queue<Integer> q= new LinkedList<>();
 int[] distance = new int[N];
  Arrays.fill(distance, -1);


bfs(0,q,adj,distance); 

return distance;    }

void bfs(int src, Queue<Integer> q, List<List<Integer>> adj,int[] distance){
    distance[src]=0;
    q.add(src);

    while(!q.isEmpty()){
        int node= q.poll();
        for(int it:adj.get(node)){
         if(distance[it]==-1 ) {
            distance[it]= distance[node]+1;
            q.offer(it);
          
        }

        
    } 

}
}}

 class Main {
    public static void main(String[] args) {

        int N = 9;
        int M = 10;

        int[][] edges = {
            {0, 1},
            {0, 3},
            {1, 3},
            {1, 2},
            {2, 6},
            {3, 4},
            {4, 5},
            {5, 6},
            {6, 7},
            {6, 8}
        };

        shortestPath obj = new shortestPath();

        int[] ans = obj.shortestPath(edges, N, M);

        System.out.println("Shortest distance from source (0):");

        for (int i = 0; i < N; i++) {
            System.out.println("Node " + i + " -> " + ans[i]);
        }
    }
}

