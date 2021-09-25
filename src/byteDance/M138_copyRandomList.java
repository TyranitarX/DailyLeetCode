package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/25 18:14
 **/

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class M138_copyRandomList {
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode newhead = head;
        while (head != null) {
            RandomNode newnode = new RandomNode(head.val);
            RandomNode next = head.next;
            head.next = newnode;
            newnode.next = next;
            head = next;
        }
        head = newhead;
        while (head != null) {
            RandomNode cur = head.next;
            cur.random = head.random != null ? head.random.next : null;
            head = head.next.next;
        }
        head = newhead;
        RandomNode res = head.next;
        while (head!=null&&head.next != null) {
            RandomNode next = head.next;
            head.next = head.next.next;
            next.next = next.next != null ? next.next.next : null;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomNode node1 = new RandomNode(7);
        RandomNode node2 = new RandomNode(13);
        RandomNode node3 = new RandomNode(11);
        RandomNode node4 = new RandomNode(10);
        RandomNode node5 = new RandomNode(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        new M138_copyRandomList().copyRandomList(node1);
        System.out.println(123);
    }
}
