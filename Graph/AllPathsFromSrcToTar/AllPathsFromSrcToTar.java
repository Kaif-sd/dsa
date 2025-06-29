package Graph.AllPathsFromSrcToTar;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToTar {
    
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

    private static void printGraphDFS(ArrayList<Edge>[] graph , int n , boolean []visited) {
        System.out.println(n);
        visited[n]= true; 

        for (int i = 0; i < graph[n].size(); i++) {
            if(!visited[graph[n].get(i).dest]){
                
                printGraphDFS(graph, graph[n].get(i).dest , visited);
            }
        }
    }


    public static List<List<Integer>> findAllPaths(ArrayList<Edge>[] graph, int start, int end, List<Integer> inList, List<List<Integer>> result, boolean[] visited) {
       
        inList.add(start);
        
        if(start == end){
            result.add(new ArrayList<>(inList));
            return result;
        }else{
            // System.out.println(start + " with list " + inList);
            List<Edge> edges = graph[start];
            for (Edge e : edges) {
                if(!visited[e.dest]){
                    visited[e.dest] = true;
                    result = findAllPaths(graph, e.dest, end ,inList, result, visited);
                    visited[e.dest] = false;
                    inList.remove(inList.size()-1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[7];
        createGraph(graph);
        boolean [] visited = new boolean[graph.length];
        List<List<Integer>>  x = findAllPaths(graph, 2, 3, new ArrayList<Integer>(), new ArrayList<List<Integer>>() , visited);
        System.out.println(x);    
    }

}


//    1  3
// 0        5  6
//    2  4
