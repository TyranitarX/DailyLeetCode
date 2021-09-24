package byteDance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/24 16:47
 * <p>
 * <p>
 * <p>
 * 合并k个有序链表 优先级队列方法
 **/
public class H23_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode nodes = null;
        ListNode res = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode now = queue.poll();
            if (nodes == null) {
                nodes = new ListNode(now.val);
                res = nodes;
            } else {
                nodes.next = new ListNode(now.val);
                nodes = nodes.next;
            }
            if (now.next != null) {
                queue.offer(now.next);
            }
        }
        return res;
    }
}
