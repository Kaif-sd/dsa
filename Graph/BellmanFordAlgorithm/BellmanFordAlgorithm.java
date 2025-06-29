package Graph.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {
    
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
        graph[1].add(new Edge(1 , 2 ,-4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4 , 4));
        graph[4].add(new Edge(4, 1 ,-1));

    }
    
    public static int [] bellmanFordsAlgorithm(ArrayList<Edge> [] graph , int src){
        int size = graph.length;
        int [] dist = new int[size];

        for (int i = 0; i < dist.length; i++) {
            if(i!= src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                List<Edge> edges = graph[j];

                for (Edge edge : edges) {
                    int u = edge.src;
                    int v = edge.dest;
                    if(dist[u] < Integer.MAX_VALUE && dist[u] + edge.wt < dist[v]){
                        dist[v] = dist[u] + edge.wt;
                    }
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) {
        int size = 5;
        ArrayList<Edge> [] graph = new ArrayList[size];
        createGraph(graph);
       int []r = bellmanFordsAlgorithm(graph, 0);
       for (int i : r) {
        System.out.println(i);
       }
    }

    
}
