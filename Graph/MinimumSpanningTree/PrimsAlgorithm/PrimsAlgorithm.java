package Graph.MinimumSpanningTree.PrimsAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    
    static class Edge{
        int src;
        int dest; 
        int wt;
        
        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class  Graph {

        static ArrayList<Edge> [] graph = null;
        public Graph(int size){
            graph = new ArrayList[size];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public static void addEdge(int src , int dest ,int wt){
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
        
    }


    static class Pair implements Comparable<Pair>{
        int src;
        int node;
        int cost;
        public Pair(int src,int node , int cost){
            this.src = src;
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static int primsAlgorithm(ArrayList<Edge> [] graph , int src){
        int size = graph.length;
        boolean [] visited = new boolean[size];
        int cost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Edge> MSTEdges = new ArrayList<>();
        pq.add(new Pair(src ,src, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if(!visited[pair.node]){
                visited[pair.node] = true;
                MSTEdges.add(new Edge(pair.src, pair.node, pair.cost));
                cost += pair.cost;
                List<Edge> edges = graph[pair.node];
                for (Edge edge : edges) {
                    if(!visited[edge.dest]){
                        pq.add(new Pair(edge.src ,edge.dest, edge.wt));
                    }
                }
            }
        }

        for (Edge edge : MSTEdges) {
            System.out.println(edge.src +" -> "+edge.dest);
        }
        return cost;
    }  
 
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        Graph.addEdge(0, 1,10);
        Graph.addEdge(0,2,15);
        Graph.addEdge(0,3,30);
        Graph.addEdge(1,3,40);
        Graph.addEdge(2,3,50);
        
        int x= primsAlgorithm(Graph.graph, 0);
        System.out.println(x);
    }
}

//             0

//      1            2

//             3