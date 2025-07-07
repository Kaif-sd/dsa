package Graph.ArticulationPointINGraph.UsingTarjansAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UsingTarjansAlgorithm {
    
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Graph{
        ArrayList<Edge> [] graph = null;
        Graph(int size){
            graph = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                graph[i] = new ArrayList<Edge>();
            }
        }

        public void addVertex(int src , int dest , int wt){
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }

    public static void main(String[] args) {
        int size = 6;
        Graph graph = new Graph(size);
        graph.addVertex( 0, 1, 0);
        graph.addVertex( 1, 2, 0);
        graph.addVertex( 2, 0, 0);
        graph.addVertex( 0, 3, 0);
        graph.addVertex( 3, 4, 0);

        boolean [] visited = new boolean[size];
        int [] disT = new int[size];
        int [] low = new int[size];
        int []time = new int[1];
        int parent = -1;

        Set<Integer> ap = findAP(graph.graph , 0 , visited ,disT, low, time, parent , new HashSet<>());
        System.out.println(ap);
    }

    private static Set<Integer> findAP(ArrayList<Edge>[] graph, int src, boolean[] visited, int[] disT, int[] low,
        int [] time, int parent, Set<Integer> result) {

        visited[src] = true;
        disT[src] = low[src] = ++time[0];
        int children = 0;

        for ( Edge e : graph[src]) {
            if(e.dest == parent){
                continue;
            }else if(visited[e.dest]){
                low[src] = Math.min( low[src] , disT[e.dest]);
            }else{
                findAP(graph, e.dest, visited, disT, low, time, src, result);
                low[src] = Math.min( low[src], low[e.dest]);
                if(disT[src] <= low[e.dest] && parent != -1){
                    result.add(src);
                }
                children++;
            }
        }
        if(parent == -1 && children > 1){
            result.add(src);
        }

        return result;
    }

    
}
