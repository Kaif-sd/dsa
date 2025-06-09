package LinkedList.Linked_List_Cycle_Detect;

public class Linked_List_Cycle_Detect {
    
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
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(isCyclicLinkedList(list.head));
    }

    public static boolean isCyclicLinkedList(Node head){
        Node one = head;
        Node two = head;

        while (two != null && two.next != null) {

            one = one.next;
            two = two.next.next;

            if(one == two){
                return true;
            }
        }
        return false;
    }

}

// Output:-

// false


// Explaination :- 

//  2. Linked List Cycle
//  Given the head, the head of a linked list, determine if the linked list
//  has a cycle in it.
//  There is a cycle in a linked list if there is some node in the list that
//  can be reached again by continuously following the next pointer.
//  Internally, pos is used to denote the index of the node that the
//  tail's next pointer is connected to. Note that pos is not passed as a
//  parameter.
//  Return true if there is a cycle in the linked list. Otherwise, return
//  false.
//  Input: head = [3,2,0,-4], pos = 1
//  Output: true
//  Explanation: There is a cycle in the linked list,
//  where the tail connects to the 1st node (0-indexed).