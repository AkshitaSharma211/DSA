public class provinces {
    public int numProvinces(int[][] adj) {
int count=0;
boolean visited[] = new boolean[adj.length];
for(int i=0;i<adj.length; i++){
    if(!visited[i]){
        count++;
        dfs(i, adj,visited);
    }
}
return count;
    }


        void dfs(int node, int[][] adj, boolean[] visited){
            visited[node]= true;

            for(int j=0; j<adj.length ;j++){
                if(adj[node][j]==1 && !visited[j]){
                    visited[j]=true;
                    dfs(j, adj, visited);
                }
            }
        }
        public static void main(String[] args){
    provinces s = new provinces();
    int[][] adj = {{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}};
    System.out.println(s.numProvinces(adj));  // should print 2
}
}
