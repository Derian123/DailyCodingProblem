//Given the head of a singly linked list, reverse it in-place.

public class Problem15 {

    static class Node{

        int x;
        Node next;

        public Node(int x){
            this.x = x;
            next = null;
        }
    }

    public Node reverseLL(Node head){

        // if it's empty return null
        if(head == null) return head = null;

        // else we make references for the previous node, current node and the next node
        Node current = head;
        Node previous = null;
        Node nextNode = null;

        //we go through the list until current is null
        while(current != null) {

            //Next node will always point to the node after current
            nextNode = current.next;
            //The reference to the next node from current will be changed to previous which points to the one before it
            current.next = previous;
            //Then the previous node will point to the current node as current node will go to the next node
            previous = current;
            //The reference to the current node will point to the next node
            current = nextNode;
        }
        //We change the reference of head to point to previous as current and nextnode are null and previous points to the last node
        head = previous;
        //we return head
        return head;
    }


    public void printLL(Node head){

        Node runner = head;

        while(runner != null){
            System.out.println(runner.x);
            runner = runner.next;
        }
    }

    public static void main(String[] args) {

        Problem15 p15 = new Problem15();
        Node head = new Node(2);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(21);
        head.next.next.next.next = new Node(100);

        head = p15.reverseLL(head);
        p15.printLL(head);

    }
}
