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
        int count = 1;
        ListNode reshead = null;
        ListNode pretail = null;
        ListNode curhead = head;
        ListNode curtail = head;
        while (curtail != null) {
            if (count % k != 0) {
                curtail = curtail.next;
            } else {
                ListNode next = curtail.next;
                curtail.next = null;
                ListNode[] rev = reverse(curhead);
                if (pretail == null) {
                    reshead = rev[0];
                } else {
                    pretail.next = rev[0];
                }
                pretail = rev[1];
                curhead = next;
                curtail = next;
            }
            count++;
        }
        while (curhead != null) {
            pretail.next = curhead;
            pretail = pretail.next;
            curhead = curhead.next;
        }
        return reshead;
    }

    public ListNode[] reverse(ListNode node) {
        ListNode tail = node;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
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
