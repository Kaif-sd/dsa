package Miscellaneous.Comparator_And_Comparable_Diff;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_And_Comparable_Diff {
    
    static class Node implements Comparable<Node>{
        int data;
        int wt;

        Node(int data , int wt){
            this.data = data;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "\n data :- " + data + " wt :- " + wt ; 
        }

        @Override
        public int compareTo(Node o) {
            return this.wt - o.wt;
        }
    }

    static class MyComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.wt - o1.wt;
        }

    }
    public static void main(String[] args) {
        System.out.println("hii");
        List<Node> list = Arrays.asList(new Node(1,2), new Node(2,9),new Node(3,4),new Node(5,1));
        Collections.sort(list);
        System.out.println(list);
    }
}
