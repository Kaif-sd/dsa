package LinkedList.Reorder_List;

public class Reorder_List {

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
        public LinkedList(){}
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
        LinkedList list = new LinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        list = getRecorderList(list);
        list.printLinkedList();
    }

    private static LinkedList getRecorderList(LinkedList list) {

        Node head = list.head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow.next;
        slow.next = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        Node first = head;
        Node second = prev;

        while (first != null && second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        return list;
    }

   
}
// output:-

// 1
// 9
// 2
// 8
// 3
// 7
// 4
// 6
// 5

// Explaination:-

//  6. Reorder List
//  You are given the head of a singly linked list. The list can be
//  represented as:
//  L0 → L1 → … → Ln - 1 → Ln
//  Reorder the list to be on the following form:
//  L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//  You may not modify the values in the list's nodes. Only nodes
//  themselves may be changed.
//  Input: head = [1,2,3,4]
//  Output: [1,4,2,3]