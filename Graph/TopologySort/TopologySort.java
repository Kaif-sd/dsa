package Graph.TopologySort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologySort {
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
        // graph[3].add(new Edge(3, 4));
        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 5));
        // graph[4].add(new Edge(4, 3));
        // graph[5].add(new Edge(5, 6));

    }
    
    public static void topologySort(ArrayList<Edge> [] graph , int n , boolean [] visited , Stack<Integer> stack){
        
        visited[n] = true;

        List<Edge> edges = graph[n];
        for (Edge edge : edges) {
            if(!visited[n]){
                topologySort(graph, n, visited, stack);
            }
        }        
        stack.push(n);
    }
 
    public static void main(String[] args) {
        int size = 6;
        ArrayList<Edge> [] graph = new ArrayList[size];
        createGraph(graph);
        boolean [] visited = new boolean[size];
        Stack<Integer> stack = new Stack<>();

        for (int i=0 ; i< graph.length; i++) {
            if(!visited[i]){
                topologySort(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    } 
}

//    1  3
// 0        5
//    2  4

// output :- 
// 5
// 4
// 3
// 2
// 1
// 0