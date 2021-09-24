public class M92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftpre = null;
        ListNode lefthead = head;
        ListNode righthead = head;
        int i = 0;
        while (i < left - 1) {
            leftpre = lefthead;
            lefthead = lefthead.next;
            i++;
        }
        i = 0;
        while (i < right - 1) {
            righthead = righthead.next;
            i++;
        }
        ListNode rightnext = righthead.next;
        righthead.next = null;
        ListNode[] res = reverse(lefthead);
        if (leftpre != null) leftpre.next = res[0];
        else head = res[0];
        res[1].next = rightnext;
        return head;
    }

    public ListNode[] reverse(ListNode head) {
        ListNode last = head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, last};
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new M92_reverseBetween().reverseBetween(node, 2, 4));
    }
}
