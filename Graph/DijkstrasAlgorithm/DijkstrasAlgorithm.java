package Graph.DijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAlgorithm {
    
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;    
            this.wt = wt;  
        }
        public Edge(){
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0 , 1 ,2));
        graph[0].add(new Edge(0 , 2,4)); 
        graph[1].add(new Edge(1 , 2 ,1));
        graph[1].add(new Edge(1, 3 ,7));
        graph[2].add(new Edge(2, 4, 3));
        graph[4].add(new Edge(4, 3 , 2));
        graph[3].add(new Edge(3, 5 , 1));
        graph[4].add(new Edge(4, 5 ,5));

    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
         public Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
         }
         @Override
         public int compareTo(Pair o) {
            return this.dist - o.dist;
         }
    }
    
    public static int [] dijkstrasAlgorithm(ArrayList<Edge> [] graph , int src){   
        int size = graph.length;
        int [] dist = new int[size];

        for (int i=0 ; i< size ; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean [] visited = new boolean[size];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.remove().node;
            if(!visited[node]){
                visited[node] = true;
                List<Edge> edges = graph[node];
                for (Edge edge : edges) {
                    int u = edge.src;
                    int v= edge.dest;
                    if(dist[u] + edge.wt < dist[v]){
                        dist[v] = dist[u] + edge.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) {
        int size= 6;
        ArrayList<Edge> [] graph = new ArrayList[size];
        createGraph(graph);
        int []r = dijkstrasAlgorithm(graph, 0);
        for (int i : r) {
            System.out.println(i);
        }
    }
}

// diagram :-

//     1     3 
// 0             5
//     2     4

// output:-
// 0
// 2
// 3
// 8
// 6
// 9

// in this code apna college did mistake . below is properly explaination of wrking

// explaination:-

// intially the value for src -  dist[src] = 0

// 1 step :- 
// then it check for edge from src to its first child -  edge[src , 1]
// here it also sets value foir dist[1] via formula dist[v]  = dist[u] + edge .wt;
// where dist[u] = dist[src] = 0
// therefore dist[v] = 0 + 2;

// 2 step:-
// then its checks for edge fro src to its second child - edge [src , 2] 
// here it also sets value foir dist[2] via formula dist[v]  = dist[u] + edge .wt;
// where dist[u] = dist[src] = 0
// therefore dist[v] = 0 + 4;

// in thisd it will set value for every node via BFS way setting value of node ie distance from src 
// based on before node and first node is src which is 0;