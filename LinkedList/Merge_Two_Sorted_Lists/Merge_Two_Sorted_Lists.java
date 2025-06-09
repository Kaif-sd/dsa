package LinkedList.Merge_Two_Sorted_Lists;

public class Merge_Two_Sorted_Lists {

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
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);


        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(5);


        LinkedList list3 = mergSortedLinkedList(list1, list2);
        list3.printLinkedList();
    }


    public static LinkedList mergSortedLinkedList(LinkedList list1 , LinkedList list2){

        Node h1 = list1.head;
        Node h2 = list2.head;

        LinkedList newList = new LinkedList();

        while (h1 != null && h2 != null) {

            if(h1.data > h2.data){
                newList.add(h2.data);
                h2 = h2.next;
            }else if (h1.data < h2.data) {
                newList.add(h1.data);
                h1 = h1.next;
            }else{
                newList.add(h1.data);
                newList.add(h2.data);
                h1 = h1.next;
                h2 = h2.next;
            }
        }

        while (h1 != null) {
            newList.add(h1.data);
            h1 = h1.next;
        }
        
        while (h2 != null) {
            newList.add(h2.data);
            h2 = h2.next;
        }
        return newList;
    }
}

//output:-
// 1
// 1
// 2
// 2
// 3
// 4
// 5

//Explaination :-
// 3. Merge Two Sorted Lists
//  You are given the heads of two sorted linked lists list1 and list2.
//  Merge the two lists in a one-sorted list. The list should be made by
//  splicing together the nodes of the first two lists.
//  Return the head of the merged linked list.
//  Input: list1 = [1,2,4], list2 = [1,3,4]
//  Output: [1,1,2,3,4,4]