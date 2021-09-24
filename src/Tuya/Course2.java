package Tuya;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Course2 {
    public ListNode removeNthFromEnd(ListNode ListNode, int n) {
        ListNode fast = ListNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = null;
        ListNode head = ListNode;
        while (fast != null) {
            fast = fast.next;
            pre = head;
            head = head.next;
        }
        pre.next = head.next;
        return ListNode;
    }

    public static void main(String[] args) {
        ListNode noe = new ListNode(1);
        noe.next = new ListNode(2);
        noe.next.next = new ListNode(3);
        noe.next.next.next = new ListNode(4);
        noe.next.next.next.next = new ListNode(5);
        noe = new Course2().removeNthFromEnd(noe, 2);
        while (noe != null) {
            System.out.println(noe.val);
            noe = noe.next;
        }
    }
}
