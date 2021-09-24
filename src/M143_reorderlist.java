public class M143_reorderlist {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseRight = reverse(slow.next);
        slow.next = null;
        while (reverseRight != null) {
            ListNode next = head.next;
            head.next = reverseRight;
            reverseRight = reverseRight.next;
            head.next.next = next;
            head = next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new M143_reorderlist().reorderList(node);
    }
}
