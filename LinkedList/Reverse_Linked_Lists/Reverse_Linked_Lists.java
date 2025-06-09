package LinkedList.Reverse_Linked_Lists;

public class Reverse_Linked_Lists {

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

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(6);

        
        list.head = reverseLinkedList(list.head);

        list.printLinkedList();
    }

    public static Node reverseLinkedList(Node x){
        if(x == null){
            return null;
        }

        Node curr = x;
        Node prev = null;
        while (curr != null) {
            Node nextNode = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

//output:-

// 6
// 5

//Explaination :- 

// 1. Reverse Linked Lists
//  Given the head of a singly linked list, reverse the list, and return
//  the reversed list.
//  Input: head = [1,2,3,4,5]
//  Output: [5,4,3,2,1]