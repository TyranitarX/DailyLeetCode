package byteDance;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class H25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = null;
        ListNode pre = null;
        ListNode now = head;
        ListNode tail = head;
        int p = 1;
        while (tail != null) {
            if (p % k != 0) {
                tail = tail.next;
            } else {
                ListNode next = tail.next;
                tail.next = null;
                ListNode[] rever = reverse(now);
                if (pre != null) {
                    pre.next = rever[0];
                } else {
                    res = rever[0];
                }
                pre = rever[1];
                now = next;
                tail = next;
            }
            p++;
        }
        if (now != null) {
            pre.next = now;
        }
        return res;
    }

    public ListNode[] reverse(ListNode head) {
        ListNode tail = head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, tail};
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode = new H25_reverseKGroup().reverseKGroup(listNode, 2);
        System.out.println(1);
    }
}
