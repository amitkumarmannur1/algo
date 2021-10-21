package practice.LinkedList;

public class SingleLinkedList {

    public static void main(String[] asd) {

        LinkedList l = new LinkedList();
//        l.addToFront(1);
//        l.addToFront(2);
//       l.addToFront(3);
//        l.addToFront(4);

        System.out.println("------------------------------");
        l.printList(l.head);

        //l.addToEnd(5);
        l.addToEnd(5);
        System.out.println("------------------------------");
        l.printList(l.head);

        System.out.println("------------------------------");

        //l.printList(l.addAtPositionN(l.head, 6, 0));


        l.insert(2, 6);
        System.out.println("------------------------------");
        l.printList(l.head);


    }
}
