import java.util.*;
class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

List<List<Integer>> adj = new ArrayList<>();
for(int i=0;i< V;i++) adj.add(new ArrayList<>());
        for(List<Integer> edge: edges){
            int u= edge.get(0);
            int v= edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        
        int count=0;
        boolean visited[] = new boolean[V];
    for(int i=0;i<V;i++){
        if(!visited[i]){
            count++;
            dfs(i,adj, visited);
        }
    }
    return count;
    }

    void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node]= true;
        for(int neighbor : adj.get(node)){
             if(!visited[neighbor]){
                dfs(neighbor, adj, visited);
             }
        }
    }

    public static void main(String[] args){
    Solution s = new Solution();
    
    List<List<Integer>> edges = new ArrayList<>();
    edges.add(Arrays.asList(0, 1));
    edges.add(Arrays.asList(1, 2));
    edges.add(Arrays.asList(3, 4));
    
    System.out.println(s.findNumberOfComponent(5, edges));  // should print 2
        }
       
    }

