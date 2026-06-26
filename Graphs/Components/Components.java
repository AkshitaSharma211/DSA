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

int dfs(int node, boolean[] visited){
    int count=1;
    visited[node] = true;
    System.out.print(node + "  ");

    for(int neighbor: adj.get(node)){
        if(!visited[neighbor]){
          count+= dfs(neighbor, visited);

        }
    }
    return count;
}

int largestComponent(){
    int largest=0;
    boolean visited[] = new boolean[Vertices];
    int count=1;
    for(int i=0;i<Vertices;i++){
        if(!visited[i]){
            count = dfs(i, visited);
                largest= Math.max(largest,count);

        }
    }
    
    return largest;
}

public static void main(String[] args){
Components g = new Components(7);
g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 3);
g.addEdge(4, 5);
g.addEdge(4, 6);
g.addEdge(5, 6);

System.out.println("Components: " + g.countComponents());
System.out.println("Largest Component: " + g.largestComponent());

}
}
    