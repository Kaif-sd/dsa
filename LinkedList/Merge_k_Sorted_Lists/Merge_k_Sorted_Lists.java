package LinkedList.Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.List;

public class Merge_k_Sorted_Lists {
    
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{

        Node head = null;

        public LinkedList(){

        }
        
        public LinkedList(int [] array){
            for (int i : array) {
                add(i);
            }
        }
        
        public void add(int data){
            Node newNode = new Node(data);

            if(head ==null){
                head = newNode;
            }else{
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            }
        }

        public void printLinkedList(){
            Node x = head;
            while (x != null) {
                System.out.println(x.data);
                x =x.next;
            }
        }

    }

    public static void main(String[] args) {

        List<LinkedList> list = new ArrayList<>();
        list.add(new LinkedList(new int[]{1,2,3}));
        list.add(new LinkedList(new int[]{3,4,5}));
        list.add(new LinkedList(new int[]{5,6,7}));
        LinkedList resultList =  mergeKSortedLists(list);
        resultList.printLinkedList();
    }

    public static LinkedList mergeKSortedLists(List<LinkedList> list){
        List<Integer> newList = new ArrayList<>();

        for (LinkedList linkedList : list) {
            Node x = linkedList.head;
            while (x != null) {
                newList.add(x.data);
                x = x.next;            }
        }
        newList.sort(null);
        int [] array = newList.stream().mapToInt(Integer::intValue).toArray();

        return new LinkedList(array);
    }

}
// output:-
// 1
// 2
// 3
// 3
// 4
// 5
// 5
// 6
// 7

//explainaton :-

//  4. Merge k Sorted Lists
//  You are given an array of k linked-lists lists, each linked list is
//  sorted in ascending order.
//  Merge all the linked lists into one sorted linked list and return it.
//  Input: lists = [[1,4,5],[1,3,4],[2,6]]
//  Output: [1,1,2,3,4,4,5,6]
//  Explanation: The linked lists are:
//  [
//  1->4->5,
//  1->3->4,
//  2->6
//  ]
//  merging them into one sorted list:
//  1->1->2->3->4->4->5->6