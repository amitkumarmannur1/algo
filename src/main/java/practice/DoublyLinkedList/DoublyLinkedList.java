package practice.DoublyLinkedList;

import java.util.List;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public void addToFront(int value) {

        List[] list = new List[10];
        Node newNode = new Node(value);

        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.i);
            n = n.next;

        }
    }


    public void addToEnd(int value) {

        Node newNode = new Node(value);

        if (tail != null) {
            tail.next = newNode;
            newNode.previous = tail;
        } else {
            head = newNode;
        }

        tail = newNode;

    }


    public void removeFromFront() {

        if (head.next == null) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.previous = null;
        }

    }


    public Node removeFromEnd() {

        Node removedNode = tail;

        if( head == tail ){
            head = null;
            tail = null;
        }
        else {
            tail = tail.previous;
            tail.next = null;
            removedNode.previous = null;
        }


        return removedNode;

    }


    public void addAtPosition(int value , int position) {

        Node newNode = new Node(value);

        List<Integer>[] l = new List[10];

        if(position == 1){
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        else if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{

            Node n = head;
            while(--position >1){

                if(n!=null){
                    n = n.next;
                }

            }
            if(n != null) {
                newNode.next = n.next;
                newNode.previous = n;
                n.next = newNode;
            }
        }
    }
}
