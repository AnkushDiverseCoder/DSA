package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    // // Input is always V and E
    // static class Edge {
    //     int src;
    //     int dest;

    //     public Edge(int s, int d) {
    //         this.src = s;
    //         this.dest = d;
    //     }
    // }

    // static void createGraph(ArrayList<Edge>[] graph) {

    //     // Initialize adjacency list
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     // Edges
    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1, 0));
    //     graph[1].add(new Edge(1, 3));

    //     graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 4));

    //     graph[3].add(new Edge(3, 1));
    //     graph[3].add(new Edge(3, 4));
    //     graph[3].add(new Edge(3, 5));

    //     graph[4].add(new Edge(4, 2));
    //     graph[4].add(new Edge(4, 3));
    //     graph[4].add(new Edge(4, 5));

    //     graph[5].add(new Edge(5, 3));
    //     graph[5].add(new Edge(5, 4));
    //     graph[5].add(new Edge(5, 6));

    //     graph[6].add(new Edge(6, 5)); // ✅ fixed index
    // }

    // // pesudo code
    // // untill Q is empty-> visit - > print -> visited true-> curr node neighbot add in q
    // public static void bfs(ArrayList<Edge> graph[],int V){
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[V];
    //     q.add(0);

    //     while(!q.isEmpty()){
    //         int curr = q.remove();
    //         if(vis[curr]==false){
    //             System.out.print(curr+" ");
    //             vis[curr] = true;
                
    //             for (int i = 0; i < graph[curr].size(); i++) {
    //                 Edge e = graph[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }

    // }
    
    // // deepth first search -> uses recursion -> stack -> memory Stack
    // // dfs(graph,curr)
    // public static void dfs(ArrayList<Edge> graph[], int curr , boolean vis[]){
    //     System.out.print(curr+" ");
    //     vis[curr] = true;

    //     for(int i=0; i<graph[curr].size();i++){
    //         Edge e = graph[curr].get(i);
    //         if(vis[e.dest]== false)
    //             dfs(graph,e.dest,vis);
    //     }
    // }

    static ArrayList<Integer> graph[] = new ArrayList[10];

    void graph(){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    static void add(int V, int dest){
        graph[V].add(dest);
    }

    static void bfs(){
        
    }

    static void dfs(){

    }

    public static void main(String[] args) {
        int V = 7;
        int E = 7;

        Scanner sc = new Scanner(System.in);

        // Method 1 Striver index(src) -> {des}

        // ArrayList<Integer> graph[] = new ArrayList[V];
        // for (int i = 0; i < E; i++) {
        //     int u,v;
        //     // undirected Graph
        //     u= sc.nextInt();
        //     v= sc.nextInt();
        //     graph[u].add(v);
        //     graph[v].add(u);

        //     // Directed Graph O(E)
        //     u= sc.nextInt();
        //     v= sc.nextInt();
        //     graph[u].add(v);
        //     // graph[v].add(u);
        // }

        // Method 2 Apna College index -> {src,des}

        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // boolean vis[] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if(vis[i] == false){
        //         dfs(graph,0,vis);
        //     }
        // }
        
        // dfs(graph,0,vis);
    }
}
