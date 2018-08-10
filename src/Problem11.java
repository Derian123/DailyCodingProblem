//Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
//For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
//Assuming all values are unique and positive

import java.util.HashMap;

public class Problem11 {

    static class Node{

        int n;
        Node next;

        public Node(int n){
            this.n = n;
            next = null;
        }
    }

    public int intersect(Node h1, Node h2){

        HashMap<Integer,Integer> map = new HashMap<>();

        Node current1 = h1;
        Node current2 = h2;

        //We check to see if one is not at the end
        while(current1 != null || current2 != null){

            //If this is not at the end
            if(current1 != null){

                //We check to see if the key is in the list from the other list
                if(map.containsKey(current1.n)) return current1.n;

                //Else we put the key in
                map.put(current1.n,current1.n);
                //Move the pointer
                current1 = current1.next;
            }
            //We do the same here as we did with current 1
            if(current2 != null){

                if(map.containsKey(current2.n)) return current2.n;

                map.put(current2.n,current2.n);
                current2 = current2.next;

            }
        }
        //If there is no intersection we return -1
        return -1;
    }

    public static void main(String[] args) {
        Problem11 p11 = new Problem11();

        Node h1 = new Node(99);
        h1.next = new Node(1);
        h1.next.next = new Node(10);

        Node h2 = new Node(3);
        h2.next = new Node(7);
        h2.next.next = new Node(8);
        h2.next.next.next = new Node(1);

        System.out.println(p11.intersect(h1,h2));



    }
}
