package Graph.StronglyConnectedComponent.KosarajusAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgorithm {
    
     static class Edge{
        int src;
        int dest;        
        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
           
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[1].add(new Edge(1 , 0 ));
        graph[0].add(new Edge(0 , 2)); 
        graph[2].add(new Edge(2 , 1 ));
        graph[2].add(new Edge(2, 1));
        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 4 ));
    }

    public static List<List<Integer>> kosarajusAlgorithm(ArrayList<Edge> [] graph , int src){
       List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> topoStack = new Stack<>();
        boolean [] visited1 = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!visited1[i]){
                topologySort(graph, src , topoStack, visited1);
            }
        }

        ArrayList<Edge> [] tGraph = transposeGraph(graph);

        boolean [] visited= new boolean[graph.length];
        while (!topoStack.isEmpty()) {
            int b = topoStack.pop();
            if(!visited[b]){
                ans.add(DFS(tGraph , b , visited , new ArrayList<Integer>()));
            }
        }
        return ans;
    }

    private static List<Integer> DFS(ArrayList<Edge>[] tGraph, int b , boolean [] visited , List<Integer> list ) {
        visited[b] = true;
        list.add(b);
        for (Edge edge : tGraph[b]) {
            if(!visited[edge.dest]){
                DFS(tGraph, edge.dest, visited ,list);
            }
        }
        return list;
    }

    private static ArrayList<Edge>[] transposeGraph(ArrayList<Edge>[] graph) {
         ArrayList<Edge> [] tGraph = new ArrayList[graph.length];
         for (int i = 0; i < tGraph.length; i++) {
            tGraph[i] = new ArrayList<Edge>();
         }
         for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                tGraph[edge.dest].add(new Edge(edge.dest, edge.src));
            }
         }
         return tGraph; 
    }

    private static void topologySort(ArrayList<Edge>[] graph, int src, Stack<Integer> topoStack, boolean[] visited ) {
        visited[src]= true;
        List<Edge> edges = graph[src];
        for (Edge edge : edges) {
            if(!visited[edge.dest]){
                topologySort(graph, edge.dest, topoStack, visited);
            }
        }
        // System.out.println(src);
        topoStack.push(src);
    }

    public static void main(String[] args) {

        ArrayList<Edge> [] graph = new ArrayList[5]; 
        createGraph(graph);

        System.out.println(kosarajusAlgorithm(graph, 0));
 
    }
}
