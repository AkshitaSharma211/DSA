package Graphs.CycleDetection;
import java.util.*;
class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        int parent= -1; 
      
        for(int i=0;i< V ; i++){
            if(!visited[i]){
        if(dfs(i, visited, parent, adj))
            return true;
    }
}
return false;

        
    }

    boolean dfs(int node,boolean[] visited, int parent, List<Integer>[] adj ){
        visited[node]= true;

        for(int neighbor : adj[node]){
            if(!visited[neighbor]){
                if(dfs(neighbor, visited, node, adj))
        return true;
            }
        
        else if(visited[neighbor] && neighbor != parent){
    return true;  // I personally found a cycle right here
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
