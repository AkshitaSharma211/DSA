import java.util.*;
class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        int parent= -1; 
      
        for(int i=0;i< V ; i++){
            if(!visited[i]){
        if(bfs(i, visited, adj))
            return true;
    }
}
return false;

        
    }

    boolean bfs(int start,boolean[] visited,  List<Integer>[] adj ){

       Queue<int[]> q= new LinkedList<>();
       q.add(new int[]{start,-1});
       visited[start] = true;


        while(!q.isEmpty()){
           int[] curr= q.poll();
            int node=curr[0];
           int parent= curr[1];

       for(int neighbor: adj[node]){
        if(!visited[neighbor]){
           
           q.add(new int[]{neighbor,node});
           visited[neighbor]= true;
        }

        else if(visited[neighbor] && neighbor!=parent) return true;

       }
        
    }
    return false;
    }

public static void main(String[] args){
    Solution s = new Solution();
    List<Integer>[] adj = new List[5];
    for(int i = 0; i < 5; i++) adj[i] = new ArrayList<>();
    
    // graph: 0-1-2-0 (cycle) and 3-4
    adj[0].add(1); adj[1].add(0);
    adj[1].add(2); adj[2].add(1);
    adj[2].add(0); adj[0].add(2);
    adj[3].add(4); adj[4].add(3);
    
    System.out.println(s.isCycle(5, adj));  // should print true
}


}
