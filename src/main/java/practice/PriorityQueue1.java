package practice;

import java.util.PriorityQueue;

public class PriorityQueue1 {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(4);
        pq.add(3);
        pq.add(5);
        pq.add(5);
        pq.add(1);
        pq.add(2);


        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq);

    }
}
