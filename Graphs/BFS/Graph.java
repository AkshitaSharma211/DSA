import java.util.*;

public class Graph {
int Vertices;
ArrayList<ArrayList<Integer>> adj;

Graph(int v){
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

void bfs(int start){
    boolean[] visited = new boolean[Vertices];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.add(start);

    while(!queue.isEmpty()){
        int node = queue.poll();
        System.out.print(node+ "");

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}


public static void main(String[] args){
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
g.bfs(0);
    g.printGraph();
}
}

    