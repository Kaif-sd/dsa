package Graph.CycleDetectionInGraph.CycleDetectionInUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInUndirectedGraph {
    
    
    static class Edge{
        int src;
        int dest;
        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;      
        }
        public Edge(){
        }
    }

    static class  UndirectedGraph {
        static ArrayList<Edge> [] graph =  null;

        public UndirectedGraph(int n){
            this.graph = new ArrayList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Edge>();
            }
        }

        public static void addEdge(int src , int dest){
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }

    public static boolean isCyclicGraph(ArrayList<Edge> [] graph , int n , boolean [] visited  , int parent){     
        visited[n] = true;

        List<Edge> edges = graph[n];
        for (Edge edge : edges) {
            if(!visited[edge.dest]){
                if(isCyclicGraph(graph, edge.dest, visited , n)){
                    return true;
                }
            }else if(edge.dest != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        System.out.println(isCyclicGraph(graph.graph, 0, new boolean[5] ,-1));
    }
}
