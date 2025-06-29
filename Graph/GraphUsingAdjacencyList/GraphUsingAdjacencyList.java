package Graph.GraphUsingAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingAdjacencyList {

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
         graph[0].add(new Edge(0 , 5)); 
        graph[1].add(new Edge(1 , 2));
        graph[2].add(new Edge(2 , 3));
        graph[3].add(new Edge(3, 4));

    }

    public static void printGraphBFS(ArrayList<Edge> [] graph){    

        boolean []visited = new boolean[graph.length];

        Queue<Integer> que = new LinkedList();
        
        que.add(graph[0].get(0).src);
        visited[0]= true;

        while (!que.isEmpty()) {
            int x = que.poll();

            System.out.println(x +" and "+ visited[x]);

            for (int i = 0; i < graph[x].size(); i++) {
                if(!visited[graph[x].get(i).dest]){
                    que.add(graph[x].get(i).dest);
                    visited[graph[x].get(i).dest]= true;
                }
            }

        }
    }

    private static void printGraphDFS(ArrayList<Edge>[] graph , int n , boolean []visited) {
        if(graph[n] == null){
            return;
        }

        System.out.println(n);
        visited[n]= true; 

        for (int i = 0; i < graph[n].size(); i++) {
            if(!visited[graph[n].get(i).dest]){
                
                printGraphDFS(graph, graph[n].get(i).dest , visited);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[6];

        createGraph(graph);

        printGraphBFS(graph);

        printGraphDFS(graph,0 , new boolean [graph.length]);

    }

}
