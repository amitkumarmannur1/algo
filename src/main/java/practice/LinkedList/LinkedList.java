package practice.LinkedList;

public class LinkedList {

    Node head;

    void addToFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    void addToEnd(int value) {

        Node endNode = new Node(value);
        if (head == null) {
            head = endNode;
            return;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = endNode;

    }


    void addAtPositionN(int value, int position) {

        Node endNode = new Node(value);

        int i = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            i++;

            if (i == 2) {
                Node temp = n.next;
                n.next = endNode;
                endNode.next = temp;
            }
        }

    }

    Node addAtPositionN(Node head, int data, int position) {
        if (position == 0) {
            Node node = new Node(data);
            node.next = head;
            return node;
        }
        head.next = addAtPositionN(head.next, data, position - 1);
        return head;
    }

    public void insert(int position, int value) {
        Node newNode = new Node(value);
        if (position <=1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node node = head;
            while (--position > 1) {
                if (node != null) {
                    node = node.next;
                }

            }
            if (node != null) {
                newNode.next = node.next;
                node.next = newNode;

            }
        }
    }

    void printList(Node n) {
        while (n != null) {
            System.out.println(n.i);
            n = n.next;
        }
    }

}
