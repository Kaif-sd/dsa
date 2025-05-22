package Arrays.Kth_Largest_Element_in_an_Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
public class Kth_Largest_Element_in_an_Array {
    

    public static int findKthLargestElementUsingHeap( int array[] , int Kth){
       Queue<Integer> queue = new PriorityQueue<>();
       for (int a : array) {
            queue.add(a);
            if(queue.size() > Kth){
                queue.poll();
            }
       }
       return queue.poll();
    } 

    public static int findKthLargestElementUsingSort( int array[] , int Kth){
        Arrays.sort(array);
        return array[array.length - Kth];
    } 

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8};
        System.out.println(findKthLargestElementUsingHeap(array, 1)); 
        
        // System.out.println(findKthLargestElementUsingSort(array, 1)); 
    }
}

// output :-

// 8