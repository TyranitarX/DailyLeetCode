/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/22 15:10
 **/
public class M725_splitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode next = head;
        while (next != null) {
            len++;
            next = next.next;
        }
        int per = len / k;
        int rest = len % k;
        int[] lens = new int[k];
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            lens[i] = rest > 0 ? per + 1 : per;
            rest--;
        }
        for (int i = 0; i < k; i++) {
            res[i] = head;
            for (int j = 0; j < lens[i]; j++) {
                if (j != lens[i] - 1) {
                    head = head.next;
                } else {
                    ListNode temp = head.next;
                    head.next = null;
                    head = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
