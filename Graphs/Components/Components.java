import java.util.*;

public class Components {
int Vertices;
ArrayList<ArrayList<Integer>> adj;

Components(int v){
    Vertices =v;
    adj=new ArrayList<>();
    for(int i=0;i<Vertices;i++){
        adj.add(new ArrayList<>());


    }
}

void addEdge(int u,int v){

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void printGraph(){
        for(int i=0;i< Vertices; i++){
                System.out.print(i+"->");
                System.out.println(adj.get(i));
            }
        }
    

 int countComponents(){
        boolean visited[] = new boolean[Vertices];
        int count= 0;

        for(int i=0;i<Vertices; i++){
            if(!visited[i]){
                count++;
            dfs(i, visited);
        }}
        return count;
    }

void dfs(int node, boolean[] visited){
    visited[node] = true;
    System.out.print(node + "  ");

    for(int neighbor: adj.get(node)){
        if(!visited[neighbor]){
            dfs(neighbor, visited);
        }
    }
}


public static void main(String[] args){

     Components g = new Components(5);
g.addEdge(0, 1);
g.addEdge(2, 3);
// node 4 is alone
System.out.println("Components: " + g.countComponents());
}
}
    