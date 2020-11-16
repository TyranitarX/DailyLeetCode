package M_328;

public class M328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;
        while (odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.next.next.val);
        System.out.println(node.next.next.next.next.val);
        System.out.println(node.next.next.next.next.val);
        System.out.println(node.next.next.next.next.next.val);
        System.out.println(node.next.next.next.next.next.next.val);
        new M328_oddEvenList().oddEvenList(node);
    }
}
