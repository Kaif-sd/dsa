package Graph.BridgeInGraph.UsingTarjansAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class UsingTarjansAlgorithm {
    
    static int temp=1;
    
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src , int dest , int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Graph {
        ArrayList<Edge> [] graph = null;
        Graph(int size){
            graph = new ArrayList[size];
            for (int i=0 ; i< size ; i++) {
                graph[i] = new ArrayList<>();
            }
        }
        
        public void addvertex(int src , int dest , int wt){
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }
    
    static class Pair {
        int src;
        int dest;
        Pair(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addvertex(0, 1, 0);
        graph.addvertex(1, 2, 0);
        graph.addvertex(2, 0, 0);
        graph.addvertex(0, 3, 0);
        graph.addvertex(3, 4, 0);
        graph.addvertex(4, 5, 0);
        graph.addvertex(5, 3, 0);

        boolean [] visited = new boolean[6];
        int [] dist = new int[6];
        int [] low = new int[6];

        List<Pair> bridgeList = findBridgeUsingTarjansAlgo(graph.graph,0 , visited ,dist , low , new ArrayList<>() ,-1 );

         for (Pair p: bridgeList) {
            System.out.println(p.src + " to " + p.dest);
         }
    }

    private static List<Pair> findBridgeUsingTarjansAlgo(ArrayList<Edge> [] graph, int src,
         boolean [] visited, int [] dist , int [] low , List<Pair> bridgList , int parent) {

            visited[src] = true;
            dist[src] = temp;
            low[src] = temp;
            temp = temp+1;

            for ( Edge e : graph[src]) {
                if(e.dest == parent){ 
                    continue;
                }
                else if(!visited[e.dest]){
                    findBridgeUsingTarjansAlgo(graph, e.dest, visited, dist, low , bridgList , src);

                    if(low[e.dest] > dist[src]){
                        bridgList.add(new Pair(src, e.dest));
                    }

                    low[src] = Math.min(low[src] , low[e.dest]);
                }
                else if(visited[e.dest]){
                    low[src] = Math.min( low[src], dist[e.dest]) ; // if e.dest is already visited then compare low of src and olow od e.dest then set low of src as min between them 
                }
            }
        return bridgList;
    }

}
