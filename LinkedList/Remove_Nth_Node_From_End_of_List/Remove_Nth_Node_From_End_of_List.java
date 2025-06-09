package LinkedList.Remove_Nth_Node_From_End_of_List;

public class Remove_Nth_Node_From_End_of_List {

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
        LinkedList list = new LinkedList(new int[]{1,2,3,4,5});
        // list.printLinkedList();
        // list = removeNodeFromLast(list,0);
        list = removeNodeFromLastUsingSlowFast(list, 2);
        list.printLinkedList();
    }

    public static LinkedList removeNodeFromLast(LinkedList list , int pos){
        if(list.head == null){
            System.out.println("invalid List");
            return list;
        }
        Node x = list.head;
        int count=1;
        while (x.next != null) {
            x = x.next;
            count++;
        }

        if(pos <= 0 || pos > count){
            System.out.println("invalid position");
            return list;
        }

        System.out.println(x.data +"with " + count);
        int i = 1;
        int posfromfront = count - pos;
        x = list.head;
        while (i != posfromfront) {
            i++;
            x = x.next;
        }
        x.next = x.next.next;

        return list;
    }

    public static LinkedList removeNodeFromLastUsingSlowFast(LinkedList list , int posFromLast){
        Node slow = list.head;
        Node fast = list.head;

        int i=0;
        while (i != posFromLast) {
            fast = fast.next;
            i++;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return list;
    }

}

// output :-
// 1
// 2
// 3
// 5

//Explaination :-
// 5. Remove Nth Node From End of List
//  Given the head of a linked list, remove the nth node from the end
//  of the list and return its head.
//  Input: head = [1,2,3,4,5], n = 2
//  Output: [1,2,3,5]