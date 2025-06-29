package Graph.FindSortestDistanceBetween2Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.PriorityQueue;

public class FindSortestDistanceIn2Points {
   
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
        graph[1].add(new Edge(1 , 2 ,1));
        graph[1].add(new Edge(1, 3 ,7));
        graph[2].add(new Edge(2, 4, 3));
        graph[4].add(new Edge(4, 3 , 2));
        graph[3].add(new Edge(3, 5 , 5));
        graph[4].add(new Edge(4, 5 ,1));

    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
         public Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
         }
         @Override
         public int compareTo(Pair o) {
            return this.dist - o.dist;
         }
    }

    public static void main(String[] args) {
        int size = 6;
        ArrayList<Edge> [] graph = new ArrayList[6];
        createGraph(graph);

        System.out.println(printSortedtPathbetween2Points(graph , 0 , 5));
    }

    private static List<Integer> printSortedtPathbetween2Points(ArrayList<Edge>[] graph , int tSrc , int tDest) {
        
        int size = graph.length;
        boolean [] visited = new boolean[size];
        int dist[] = new int[size];

        for(int i=0; i< dist.length ; i++){
            if(i != 0){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
    
        pq.add(new Pair(tSrc , 0));
        List<Integer> list = new LinkedList<>();

        while(!pq.isEmpty()){
            Pair x = pq.remove();
            if(!visited[x.node]){
                visited[x.node] = true;
                list.add(x.node);

                if(x.node == tDest){ 
                    return list;
                }

                for(Edge e : graph[x.node]){
                    if(dist[e.src] + e.wt < dist[e.dest]){
                        dist[e.dest] = dist[e.src]  + e.wt;
                        pq.add(new Pair(e.dest , dist[e.dest]));
                    }
                }
            }
        }
        return null;


    }

}

// diagram :-

//     1     3 
// 0             5
//     2     4
