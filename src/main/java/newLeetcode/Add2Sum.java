package newLeetcode;

public class Add2Sum {
    public ListNode sum(ListNode l1, ListNode l2){

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0); //init
        ListNode p = head;

        int car = 0;

        while(l1 != null || l2!=null || car == 1) {

            if(l1 != null) {
                car = car + l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                car = car + l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode( car % 10 );
            p = p.next;
            car = car/10;
        }

        return head.next;
    }

}
