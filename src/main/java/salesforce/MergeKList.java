package salesforce;

public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int mid = start + ((end - start) / 2);
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        // this is wrong
        ListNode dummyHead = new ListNode(1);
        ListNode cur = dummyHead;
        while(a != null && b != null) {
            if(a.val < b.val) {
                cur.next = a;
                cur = a;
                a = a.next;
            }else {
                cur.next = b;
                cur = b;
                b = b.next;
            }
        }

        if(a != null) cur.next = a;
        if(b != null) cur.next = b;

        return dummyHead.next;
    }
}
