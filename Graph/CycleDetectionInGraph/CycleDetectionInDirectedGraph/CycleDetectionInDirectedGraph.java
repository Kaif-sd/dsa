package Graph.CycleDetectionInGraph.CycleDetectionInDirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraph {
    
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

    public static void createGraph(ArrayList<Edge> [] graph){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0 , 1));
        graph[0].add(new Edge(0 , 2)); 
        graph[1].add(new Edge(1 , 3));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));
        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 3));
        graph[5].add(new Edge(5, 6));

    }


    public static boolean isCyclicGraph(ArrayList<Edge> [] graph , boolean []visited , int n , boolean []recStack ){
        visited[n] = true;
        recStack[n] = true;
        List<Edge> edges = graph[n];
        for (Edge edge : edges) {
            if(!recStack[edge.dest]){
                return true;
            }
            else if(!visited[edge.dest] && isCyclicGraph(graph, visited, n, recStack)){
                return true;
            }
        }
        return false;
    } 

    
    public static void main(String[] args) {
        ArrayList<Edge> []graph = new ArrayList[7];
        boolean [] visited = new boolean[graph.length];

        createGraph(graph);
        System.out.println(isCyclicGraph(graph, visited, 0, new boolean[7]));
    }
}



//    1  3
// 0        5  6
//    2  4
