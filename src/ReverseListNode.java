/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/5/6 21:41
 **/
public class ReverseListNode {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode now = head.next;
        ListNode next;
        pre.next = null;
        while (now != null) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = ReverseListNode.reverse(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
