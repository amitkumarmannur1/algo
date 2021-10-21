package practice.DoublyLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] asd) {
        DoublyLinkedList doublyLinkedList =new DoublyLinkedList();

     doublyLinkedList.addToFront(1);
        doublyLinkedList.addToFront(2);
       doublyLinkedList.addToFront(3);

        doublyLinkedList.printList();

        doublyLinkedList.addToEnd(5);

        doublyLinkedList.printList();
       // doublyLinkedList.addToFront(4);
        System.out.println("------------------------------");
        doublyLinkedList.printList();


        doublyLinkedList.addToEnd(7);

        System.out.println("------------------------------");
        doublyLinkedList.printList();



        doublyLinkedList.removeFromFront();
        System.out.println("------------------------------");
        doublyLinkedList.printList();

        doublyLinkedList.removeFromFront();
        System.out.println("------------------------------");
        doublyLinkedList.printList();


        doublyLinkedList.removeFromEnd();
        System.out.println("------------------------------");
        doublyLinkedList.printList();


        doublyLinkedList.removeFromEnd();
        System.out.println("------------------------------");
        doublyLinkedList.printList();


        doublyLinkedList.addToFront(1);
        doublyLinkedList.addToFront(2);
        doublyLinkedList.addToFront(3);

        System.out.println("------------------------------");
        doublyLinkedList.printList();

        doublyLinkedList.addAtPosition(7,4);

        System.out.println("------------------------------");
        doublyLinkedList.printList();
    }

}
