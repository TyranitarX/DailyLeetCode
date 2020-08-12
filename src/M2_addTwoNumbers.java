public class M2_addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addin = 0;
        ListNode sum = new ListNode(0);
        ListNode x = sum;
        ListNode xpre = x;
        ListNode l1temp = l1;
        ListNode l2temp = l2;
        while (l1temp != null && l2temp != null) {
            x.val = (l1temp.val + l2temp.val + addin) % 10;
            addin = (l1temp.val + l2temp.val + addin) / 10;
            l1temp = l1temp.next;
            l2temp = l2temp.next;
            x.next = new ListNode(0);
            xpre = x;
            x = x.next;
        }
        while (l1temp != null) {
            x.val = (l1temp.val + addin) % 10;
            addin = (l1temp.val + addin) / 10;
            l1temp = l1temp.next;
            x.next = new ListNode(0);
            xpre = x;
            x = x.next;
        }
        while (l2temp != null) {
            x.val = (l2temp.val + addin) % 10;
            addin = (l2temp.val + addin) / 10;
            l2temp = l2temp.next;
            x.next = new ListNode(0);
            xpre = x;
            x = x.next;
        }
        if (addin != 0){
            x.val = addin % 10;
            xpre = x;
        }
        xpre.next=null;
        return sum;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode sum = addTwoNumbers(l1, l2);
    }
}

